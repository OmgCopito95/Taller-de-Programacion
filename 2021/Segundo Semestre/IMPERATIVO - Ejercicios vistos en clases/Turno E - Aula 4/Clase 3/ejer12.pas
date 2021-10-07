{Implementar un programa que procese la información de las ventas de productos de una
librería que tiene 4 sucursales. De cada venta se lee fecha de venta, código del producto
vendido, código de sucursal y cantidad vendida. El ingreso de las ventas finaliza cuando se
lee el código de sucursal 0.
Implementar un programa que:
a. Almacene las ventas ordenadas por código de producto y agrupados por sucursal,
en una estructura de datos adecuada.
b. Contenga un módulo que reciba la estructura generada en el punto a y retorne
una estructura donde esté acumulada la cantidad total vendida para cada código de
producto.}

Program ejer12;

Type

str12= string[12];

r_venta = record
  fecha_venta: str12;
  codProducto: integer;
  codSucursal: integer;
  cantVentas: integer;
end;

lista = ^nodo;
nodo = record
   dato: r_venta;
   sig: lista;
end;

vSucursal = array [1..4] of lista;


r_producto = record
   producto: integer;
   totalVentas: integer;
end;

NuevaLista = ^NuevoNodo;
NuevoNodo = record
   NuevoDato: r_producto;
   NuevoSig: NuevaLista;
end;



Procedure InicializarVectorListas (VAR v:vSucursal);
Var
  i:integer;
begin
  For i:= 1 to 4 do
    v[i]:= nil;
end;



{===================== Comienzo Inciso A =====================}

Procedure Leer (VAR rv:r_venta);
begin
  With rv do begin
    writeln('Ingrese el codigo de la sucursal: ');
    codSucursal:= random(5);
    If (codSucursal <> 0) then begin
      writeln('Ingrese el codigo del producto: ');
      codProducto:= random(101);
      writeln('Ingrese la cantidad de ventas: ');
      cantVentas:= random(101);
      writeln('Ingrese la fecha, dos numeros para el dia, mes y tres para el anio separado con /:');
      readln(fecha_venta);
    end;
  end;
end;

Procedure InsertarOrdenado (VAR L:lista; rv:r_venta);
Var
  nuevo:lista;
  act,ant: lista;  
begin
  new(nuevo);
  nuevo^.dato:= rv;
  act:= L;
  ant:= L;
  While (act <> nil) AND (rv.codProducto > act^.dato.codProducto) do begin
     ant:= act;
     act:= act^.sig;
  end;
  If (act = ant) then
    L:= nuevo
  Else
    ant^.sig:= nuevo;
 nuevo^.sig:= act;
end;

Procedure CargarVectorLista (VAR v:vSucursal);
Var
  rv:r_venta;
begin
  Leer(rv);
  While (rv.codSucursal <> 0) do begin
    InsertarOrdenado (v[rv.codSucursal],rv);
    writeln;
    Leer(rv);
  end;
end;

{===================== Fin Inciso A =====================}





Procedure Imprimir (v:vSucursal);
Var
  i: integer;
begin
  For i:= 1 to 4 do begin
     writeln('-->> En la Sucursal ',i,': ');
    While (v[i] <> nil) do begin
      writeln('Codigo de producto: ',v[i]^.dato.codProducto,' con ',v[i]^.dato.cantVentas,' ventas');
      v[i]:= v[i]^.sig;
    end;
    writeln('-------------------------');
  end;
end;






{===================== Comienzo Inciso B=====================}

procedure AgregarAtras (var L:NuevaLista; rp:r_producto);
var 
 act: NuevaLista;
 nue: NuevaLista;
begin 
 new (nue);
 nue^.NuevoDato:= rp;
 nue^.NuevoSig := nil;
 if (L <> nil) then begin
     act := L;
     while  (act^.NuevoSig <> NIL ) do 
         act := act^.NuevoSig ;
     act^.NuevoSig := nue ;
    end
 else
    L:= nue;
end;



Procedure minimo (var v:vSucursal ; VAR codMin:integer ;VAR cantCodMin:integer);
Var
 indiceMin,i:integer;
Begin
  codMin:= 9999; 
  indiceMin:= -1;
  for i:= 1 to 4 do begin
     If (v[i] <> nil) AND (v[i]^.dato.codProducto <= codMin) then begin
           codMin:= v[i]^.dato.codProducto;
           indiceMin:= i;
       end; 
  end;
  If (indiceMin <> -1) then begin
    cantCodMin:= v[indiceMin]^.dato.cantVentas;
    v[indiceMin]:= v[indiceMin]^.sig;
  end;
End;



Procedure mergeAcumulador (v: vSucursal; var LN:NuevaLista);
Var
  rp:r_producto;
  actual,codMin,cantCodMin,ventasTotales: integer;
Begin
  LN:= nil;
  minimo (v,codMin,cantCodMin);
  while (codMin <> 9999) do begin
     actual:= codMin; 
     ventasTotales:=0;
     while (codMin <> 9999) and ( codMin = actual) do begin
        ventasTotales:= ventasTotales + cantCodMin;
        minimo (v,codMin,cantCodMin);
     end;
     rp.producto:= actual;
     rp.totalVentas:= ventasTotales;
     agregarAtras(LN,rp);
    end;
End;  


{===================== Fin Inciso B =====================}




Procedure ImprimirNuevaLista (L:NuevaLista);
Begin
  while (L <> nil) do begin
    writeln('El codigo ',L^.NuevoDato.producto,' obtuvo ',L^.NuevoDato.totalVentas,' ventas en total');
    writeln;
    L:= L^.NuevoSig;
  end;
End;




{================= PROGRAMA PRINCIPAL =================}
VAR
  v:vSucursal;
  LN: NuevaLista;
Begin
  InicializarVectorListas (v);
  CargarVectorLista (v);
  Imprimir (v);
  mergeAcumulador (v,LN);
  writeln;
  writeln('TOTAL DE VENTAS POR CODIGO:');
  writeln;
  ImprimirNuevaLista(LN);
End.
