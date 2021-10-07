{12. Implementar un programa que procese la información de las ventas de productos de una
librería que tiene 4 sucursales. De cada venta se lee fecha de venta, código del producto
vendido, código de sucursal y cantidad vendida. El ingreso de las ventas finaliza cuando se
lee el código de sucursal 0.
Implementar un programa que:
a. Almacene las ventas ordenadas por código de producto y agrupados por sucursal,
en una estructura de datos adecuada.
b. Contenga un módulo que reciba la estructura generada en el punto a y retorne
una estructura donde esté acumulada la cantidad total vendida para cada código de
producto.}
program Hello;
uses
    sysutils;
const
    dimF = 4; // cantidad de sucursales
    FIN = 0;
type
    rangoVenta = 1..dimF;
    cadena15 = string[15];
    venta = record
        fecha:cadena15;
        codProd:integer;
        codSucursal: integer;
        cantVendida:integer;
    end;
    
    lista =^nodo;
    nodo = record
        dato:venta;
        sig:lista;
    end; 
    vecVentas = array [rangoVenta] of lista;
    
    ventaXCod = record
        codProd:integer;
        totalVentas:integer;
    end;
    
    lista2 = ^nodo2;
    nodo2 = record
        dato:ventaXCod;
        sig:lista2;
    end;
//----------Fin del type ----------

//----------Leer Venta-----------------
procedure leerVenta (var v:venta);
begin
    v.codSucursal := random (5);
    writeln ('Codigo de sucursal: ',v.codSucursal);
    if (v.codSucursal <> FIN) then begin
        v.codProd := random (50)+1;
        v.cantVendida := random (100);
        v.fecha := concat ( 'Fecha: - ', IntToStr (v.codProd));
        writeln ('Cantidad de productos vendidos: ',v.cantVendida);
        writeln ('Codigo de producto: ',v.codProd);
        writeln ('Fecha de venta: ',v.fecha);
    end;
end;
//---------Inicializar Vec de listas----------------
procedure inicializarVector(var vec: vecVentas);
var
    i: integer;
begin
    for i := 1 to dimF do
        vec[i] := nil; //tengo que inicializar en nil porque es un vector de listas
end;
//--------Insertar ordenado-------------
procedure insertarOrdenado(var L : lista; dato : venta);
var
	aux,ant,act : lista;
	
begin
	new(aux); 
	aux^.dato := dato;
	act := L;
	ant := act;
	while (act <> nil) and (act^.dato.codProd < dato.codProd) do begin
		ant := act;
		act := act^.sig;
	end;
	if (ant=act) then begin //primero de la lista, o lista vacía
		aux^.sig := L;
		L := aux;
	end 
	else begin
		ant^.sig := aux;
		aux^.sig := act;
	end;
end;
//------------Cargar lista------------------------
procedure cargarListaEnVec ( var vec:vecVentas);
var
    ven:venta;
    i:rangoVenta;
begin
    leerVenta(ven);
    while (ven.codSucursal <> FIN) do begin
       insertarOrdenado(vec[ven.codSucursal], ven);
       leerVenta(ven);
    end;
end;
//---------Agregar atras-----------
procedure agregarAtras(var l, ult :lista2; ven:ventaXCod);
var
    nue:lista2;
begin
	new(nue);
	nue^.dato := ven;
	nue^.sig := nil;
	if (l = nil) then
		l := nue
	else
		ult^.sig := nue;
	ult := nue;	
end;
//-----------Minimo----------------
procedure minimo (var vec:vecVentas; var min:venta); //deberias pasar el nuevo registro para la nueva lista
var                                                   // var min:ventaXCod
    pos,i:integer;
begin
  min.codProd:=999;
  pos:= -1;
  for i:= 1 to dimF do
     if (vec[i] <> nil) then 
       if (vec[i]^.dato.codProd <= min.codProd) then begin
            pos:= i; {guarda la posicion de la lista}  
            min:= vec[i]^.dato;{actualiza min}            //guardar solo el codigo de producto
        end; 
  if (pos <> -1) then {si encontre un minimo, avanzo}
      vec[pos]:= vec[pos]^.sig;                           //guardar el resto de los datos
end;
//------------ Merge -------------
Procedure merge (vec:vecVentas; var nuevo:lista2);
var
    min:venta; //DEBERIA SER VENTAXCOD
    infoVentaActual:ventaXCod; //acá voy a ir almacenando la informacion de cada venta agrupada por código
    ult: lista2;
    prodActual: integer;
begin
  nuevo:= nil;
  minimo (vec, min); // se devuelve el primer minimo
  while (min.codProd <> 999) do begin
      infoVentaActual.codProd:=min.codProd; //corte de control
     infoVentaActual.totalVentas:=0; // inicializo el total de ventas para el prod actual
     while ((min.codProd <> 999) and (min.codProd = infoVentaActual.codProd)) do begin  // mientras siga viniendo el mismo producto, sumo 1
        infoVentaActual.totalVentas:= infoVentaActual.totalVentas + min.cantVendida;
        minimo (vec, min);
     end;
     agregarAtras(nuevo,ult,infoVentaActual); // agrego el nuevo registro CARGADO a la lista (merge acumulador)
    end;
End;  

//-------------Imprimir Lista-----------------------
procedure imprimirLista(l:lista);
begin
    while (l<>nil) do begin
        writeln('COD PRODUCTO: ',l^.dato.codProd); 
        writeln ('FECHA DE VENTA: ',l^.dato.fecha);
        writeln('CANTIDAD VENDIDA: ',l^.dato.cantVendida);
        l:=l^.sig;
    end;
end;
//-------------Imprimir arreglo-----------------------
procedure imprimirArreglo(vec:vecVentas);
var
    i:rangoVenta;
begin
   for i:=1 to dimF do begin
        writeln('Para la sucursal: ',i);
        imprimirLista(vec[i]);
    end;
    writeln('______________');

end;
//---------imprimirListaMerge------
procedure imprimirListaMerge(l:lista2);
begin
    while (l<>nil) do begin
        writeln('COD PRODUCTO: ',l^.dato.codProd); 
        writeln('TOTAL DE VENTAS: ',l^.dato.totalVentas);
        l:=l^.sig;
    end;
end;
//----------Programa principal ----------
var 
    vec:vecVentas;
    l:lista;
    ln:lista2;
begin
    inicializarVector(vec);
    cargarListaEnVec(vec);
    imprimirArreglo(vec);
    merge(vec,ln);
    imprimirListaMerge(ln);
end.


