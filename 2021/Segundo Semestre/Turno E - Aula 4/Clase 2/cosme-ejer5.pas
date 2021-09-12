{Escribir un programa que:
a. Implemente un módulo que genere un vector de 20 números enteros.
b. Implemente un módulo recursivo que devuelva el máximo valor del vector.
c. Implementar un módulo recursivo que devuelva la suma de los valores contenidos en el vector.}

Program ejer5;
const
  dimF= 3;

Type
  vector = array [1..dimF] of integer;




{==================== Comienzo Inciso A ====================}

Procedure CargarVector (VAR v:vector);
Var
  i,num: integer;
begin
  For i:= 1 to dimF do begin
    writeln ('Ingrese un numero');
    readln (num);
    v[i]:= num;
  end;
end;

{==================== Fin Inciso A ====================}




{==================== Comienzo Inciso C ====================}

Function MAXIMO (i: integer; v:vector; max:integer):integer;
begin
  If (i < dimF) then begin
    i:= i + 1;
    max:= MAXIMO (i,v,max);
    If (v[i] > max) then
      max:= v[i];
  end;
  MAXIMO:= max;
end;

{==================== Comienzo Inciso C ====================}




{==================== Comienzo Inciso D ====================}

Function SUMA (i: integer; v:vector; total:integer):integer;
begin
  If (i < dimF) then begin
    i:= i + 1;
    {writeln('en [',i,'] esta ',v[i]);}
    total:= v[i] + SUMA (i,v,total);   
  end;
 { writeln('en la poscion ',i,' esta ',v[i]);}
  SUMA:= total;
end;

{==================== Fin Inciso D ====================}




{==================== PROGRAMA PRINCIPAL ====================}

VAR
 v:vector;
 max,i,total:integer;
begin
  i:= 0;
  total:= 0;
  max:= -999;
  CargarVector (v);
  writeln('El valor MAXIMO es :',MAXIMO (i,v,max));
  writeln;
  writeln('La SUMA total es: ',SUMA(i,v,total));
End.