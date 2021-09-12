{Escribir un programa que:
a. Implemente un módulo que genere una lista a partir de la lectura de números enteros. La lectura finaliza 
    con el número -1.
b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista.
c. Implemente un módulo recursivo que devuelva el máximo valor de la lista.
d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se encuentra 
   en la lista o falso en caso contrario.}

Program ejer4;
Type
  lista = ^nodo;
  nodo = record
    dato:integer;
    sig:lista;
  end;



{==================== Comienzo Inciso A ====================}

Procedure AgregarAdelante (VAR L:lista; n:integer);
Var
  aux: lista;
begin
  new(aux);
  aux^.dato:= n;
  aux^.sig:= L;
  L:= aux;
end;


Procedure cargarLista (VAR L:lista);
Var
  num: integer;
begin
  writeln('Ingrese un numero: ');
  readln(num);
  while (num <> -1) do begin
    AgregarAdelante (L,num);
    writeln;
    writeln('Ingrese un numero: ');
    readln(num);
  end;
end;

{==================== Fin Inciso A ====================}





{==================== Comienzo Inciso B ====================}

Function MINIMO (L:lista; min:integer): integer;
begin
  If (L <> nil) then begin
     min:= MINIMO (L^.sig,min);
     If (L^.dato < min) then
       min:= L^.dato;
 end;
   MINIMO:= min;
end;

{==================== Fin Inciso B ====================}





{==================== Comienzo Inciso C ====================}

Function MAXIMO (L:lista; max:integer): integer;
begin
  If (L <> nil) then begin
    max:= MAXIMO (L^.sig,max);
    If (L^.dato > max) then
      max:= L^.dato;
  end;
  MAXIMO:= max;
end;

{==================== Fin Inciso C ====================}





{==================== Comienzo Inciso D ====================}

Function ExisteValor (L:lista; valor:integer; exito:boolean):boolean;   //FALTARIA CORTAR LA EJECUCION CUANDO ENCUENTRE EL ELEMENTO
begin
  If (L <> nil) then begin
    exito:= ExisteValor (L^.sig,valor,exito);
    If (L^.dato = valor) then
      exito:= true;
  end;
  ExisteValor:= exito;
end;

{==================== Fin Inciso D ====================}




{==================== PROGRAMA PRINCIPAL ====================}
VAR
  L:lista;
  min,max,valor: integer;
  exito:boolean;
Begin
  L:= nil;
  min:= 9999;
  max:= -9999;
  exito:= false;
  cargarLista (L);
  writeln('El valor MINIMO de la lista es: ',MINIMO(L,min));
  writeln;
  writeln('El valor MAXIMO de la lista es: ',MAXIMO(L,max));
  writeln('Ingrese numero a buscar: ');
  readln(valor);
  If (ExisteValor(L,valor,exito)) then
    writeln('el valor ingresado existe en la lista')
  Else
    writeln('El valor ingresado no existe en la lista');  
End.
