{
Escribir un programa que:
a. Implemente un módulo que genere un vector de 20 números enteros.
b. Implemente un módulo recursivo que devuelva el máximo valor del vector.
c. Implementar un módulo recursivo que devuelva la suma de los valores contenidos
en el vector
}

program ej5;

type
    vector = array [1..20] of integer;


{************* PUNTO A ***************}

procedure generarVector (var v: vector; var dimL: integer);
var
   i: integer;
begin
     for i:= 1 to 20 do
       v[i]:= Random(100);
     dimL:= 20;       // PODRIA USARSE DIMF
end;


{************* PUNTO B ***************}

function minimo (v: vector; dimL: integer; min: integer): integer;
begin
     if (dimL = 0) then
        minimo:= min
     else begin
          if (v[dimL] < min) then
             min:= v[dimL];
          minimo:= minimo (v, dimL-1, min);
     end;
end;


function maximo (v: vector; dimL: integer; max: integer): integer;
begin
     if (dimL = 0) then
        maximo:= max
     else begin
          if (v[dimL] > max) then
             max:= v[dimL];
          maximo:= maximo (v, dimL-1, max);
     end;
end;

{************* PUNTO C ***************}

function suma (v: vector; dimL: integer): integer;       // CORREGIR
begin
     if (dimL > 1) then
        suma:= v[dimL] + suma(v, dimL-1);
end;


{******** PROGRAMA PRINCIPAL *********}

var
   v: vector;
   dimL, min, max: integer;

begin
     min:= 99999;
     max:= -99999;
     generarVector (v, dimL);
     writeln('El numero maximo del vector es ', maximo(v, dimL, max));
     writeln('El numero minimo del vector es ', minimo(v, dimL, min));
     writeln('');
     writeln('La suma de todos los numeros del vector es ', suma(v, dimL));
     writeln('');
     writeln('************** FIN DEL PROGRAMA ****************');
     readln;
end.
