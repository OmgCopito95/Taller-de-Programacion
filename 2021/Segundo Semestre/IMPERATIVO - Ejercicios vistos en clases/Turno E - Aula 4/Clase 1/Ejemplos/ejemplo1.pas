{

EJEMPLO - PRACTICA 1 - IMPERATIVO
* 
* vector de numeros enteros - ordenacion por seleccion e insercion
  
}


program ejemplo1;

const
	dimF = 10;
	
type
	vector = array [1..dimF] of integer;
	

// ORDENACION DE VECTORES POR SELECCION
Procedure Ordenar ( var v: vector; dimLog: integer);
var
  i, j, p, item: integer;
begin
  for i:=1 to dimLog-1 do begin {busca el mínimo v[p] entre v[i] , ..., v[N] }
    p := i;
    for j := i+1 to dimLog do
      if v[ j ] < v[ p ] then	//ordena de menor a mayor. Para ordenar de mayor a menor, invertir el signo
        p:=j;
    {intercambia v[i] y v[p] }
    item := v[ p ];
    v[ p ] := v[ i ];
    v[ i ] := item;
  end;
end;

// ORDENACION DE VECTORES POR INSERCION
procedure OrdenacionPorInsercion(var v: vector; dimL: integer);
var 
	i, j, actual: integer;
begin

	for i:= 2 to dimL do begin
   		actual:=v[i];
   		j:= i-1;
   		while (j > 0) and (v[j] < actual) do begin
     			v[j+1]:=v[j];
     			j := j-1;
     		end;
		v[j+1] := actual;
	end;
end;


Procedure cargarVector (var v: vector; var dimL: integer);
var
   num: integer;
begin
     Randomize;  //para que funcione el random
     num:= random(100); //numero random entre 0-99
     while (num <> 99)  and ( dimL < dimF ) do begin
           dimL := dimL + 1;
           v[dimL] := num;
           num:= random(100);
     end;
End;

Procedure imprimirVector (v: vector; dimL: integer);
var
   i: integer;
begin
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if(v[i] < 9)then //le agrega un cero adelante cuando el numero es de un digito
            write ('0');
        write(v[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End; 

var
	v: vector;
	dimL: integer;
	
BEGIN
	dimL:=0;
	cargarVector(v,dimL); //carga el vector con numeros aleatorios
	imprimirVector(v,dimL);
	{Ordenar(v,dimL);
	imprimirVector(v,dimL);}
	OrdenacionPorInsercion(v,dimL);
	imprimirVector(v,dimL);
END.

