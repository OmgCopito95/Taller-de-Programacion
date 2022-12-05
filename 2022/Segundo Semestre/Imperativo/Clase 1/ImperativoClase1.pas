{Implementar un programa que procese la información de las ventas de productos de un comercio (como máximo 20). 
De cada venta se conoce código del producto (entre 1 y 15) y cantidad vendida (como máximo 99 unidades). 
El ingreso de las ventas finaliza con el código 0 (no se procesa).

a. Almacenar la información de las ventas en un vector. El código debe generarse automáticamente (random) y la edad se debe leer. 
b. Mostrar el contenido del vector resultante.
c. Ordenar el vector de ventas por código.
d. Mostrar el contenido del vector resultante.
e. Eliminar del vector ordenado las ventas con código de producto entre dos valores que se ingresan como parámetros. 
f. Mostrar el contenido del vector resultante.
g. Generar una lista ordenada por código de producto de menor a mayor a partir del vector resultante del inciso e., sólo para los códigos pares.
h. Mostrar la lista resultante.}

program Clase1MI;
const dimF = 10;
type rango1 = 0..15;
     rango2 = 1..99;
     rango3 = 0..dimF;
     venta = record
				codigoP: rango1;
				cantidad: rango2;
			 end;
	 vector = array [1..dimF] of venta;
	 lista = ^nodo;
	 nodo = record
	          dato: venta;
	          sig: lista;
	        end;

procedure AlmacenarInformacion (var v: vector; var dimL: rango3);
  
  procedure LeerVenta (var v: venta);
  begin
    Randomize;
    write ('Codigo de producto: ');
    v.codigoP:= random(16);
    writeln (v.codigoP);
    if (v.codigoP <> 0)
    then begin
           write ('Ingrese cantidad (entre 1 y 99): ');
           readln (v.cantidad);
         end;
  end;

var unaVenta: venta;
begin
    dimL := 0;
    LeerVenta (unaVenta);
    while (unaVenta.codigoP <> 0)  and ( dimL < dimF ) do 
    begin
       dimL := dimL + 1;
       v[dimL]:= unaVenta;
       LeerVenta (unaVenta);
    end;
end;

procedure ImprimirVector (v: vector; dimL: rango3);
var
   i: integer;
begin
     write ('         -');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write ('  Codigo:| ');
     for i:= 1 to dimL do begin
        if(v[i].codigoP <= 9)then
            write ('0');
        write(v[i].codigoP, ' | ');
     end;
     writeln;
     writeln;
     write ('Cantidad:| ');
     for i:= 1 to dimL do begin
        if (v[i].cantidad <= 9)then
            write ('0');
        write(v[i].cantidad, ' | ');
     end;
     writeln;
     write ('         -');
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End;

procedure Ordenar (var v: vector; dimL: rango3);

var i, j, pos: rango3; item: venta;	
		
begin
 for i:= 1 to dimL - 1 do 
 begin {busca el mínimo y guarda en pos la posición}
   pos := i;
   for j := i+1 to dimL do 
        if (v[j].codigoP < v[pos].codigoP) then pos:=j;

   {intercambia v[i] y v[pos]}
   item := v[pos];   
   v[pos] := v[i];   
   v[i] := item;
 end;
end;
procedure Eliminar (var v: vector; var dimL: rango3; valorInferior, valorSuperior: rango1);

  function BuscarPosicion (v: vector; dimL: rango3; elemABuscar: rango1): rango3;
  var pos: rango3;
  begin
    pos:= 1;
    while (pos <= dimL) and (elemABuscar > v[pos].codigoP) do
       pos:= pos + 1;
    if (pos > dimL) then BuscarPosicion:= 0
                    else BuscarPosicion:= pos;
  end;
  
  function BuscarPosicionDesde (v: vector; dimL, pos : integer; elemABuscar: rango1): rango3;
  begin
    while (pos <= dimL) and (elemABuscar >= v[pos].codigoP) do
       pos:= pos + 1;
    if (pos > dimL) then BuscarPosicionDesde:= dimL
                    else BuscarPosicionDesde:= pos - 1;
  end;

var posInferior, posSuperior, salto, i: rango3; 
Begin
  posInferior:= BuscarPosicion (v, dimL, valorInferior);
  if (posInferior <> 0)
  then begin
         posSuperior:= BuscarPosicionDesde (v, dimL, posInferior, valorSuperior);
         
         {Escribir el código correspondiente para hacer el corrimiento y disminuir la dimensión lógica}
         
       end;
end;

procedure GenerarLista (v: vector; dimL: rango3; var L: lista);

  procedure AgregarAdelante (var L: lista; elem: venta);
  begin
    { Completar }
  end;
  
  function Cumple (num: rango1): boolean;
  begin
    { Completar }
  end;
  
var i: rango3; 
begin
  L:= nil;
  for i:= dimL downto 1 do 
    if Cumple (v[i].codigoP) then AgregarAdelante (L, v[i]);
end; 

procedure ImprimirLista (L: lista);
begin
 { Completar }
end;

var v: vector;
    dimL: rango3;
    valorInferior, valorSuperior: rango1;
    L: lista;
    
Begin
  AlmacenarInformacion (v, dimL);
  writeln;
  if (dimL = 0) then writeln ('--- Vector sin elementos ---')
                else begin
                       writeln ('--- Vector ingresado --->');
                       writeln;
                       ImprimirVector (v, dimL);
                       writeln;
                       writeln ('--- Vector ordenado --->');
                       writeln;
                       Ordenar (v, dimL);
                       ImprimirVector (v, dimL);
                       {write ('Ingrese valor inferior: ');
                       readln (valorInferior);
                       write ('Ingrese valor superior: ');
                       readln (valorSuperior);
                       Eliminar (v, dimL, valorInferior, valorSuperior);
                       if (dimL = 0) then writeln ('--- Vector sin elementos, luego de la eliminacion ---')
                                     else begin
                                            writeln;
                                            writeln ('--- Vector luego de la eliminacion --->');
                                            writeln;
                                            ImprimirVector (v, dimL);
                                            GenerarLista (v, dimL, L);
                                            if (L = nil) then writeln ('--- Lista sin elementos ---')
                                                         else begin
                                                                writeln;
                                                                writeln ('--- Lista obtenida --->');
                                                                writeln;
                                                                ImprimirLista (L);
                                                              end;
                                          end;}
                      end;
                       
end.
