{Escribir un programa que:
a. Implemente un módulo que lea números enteros y los almacene en un árbol
binario de búsqueda. La lectura finaliza con el valor 0.
b. Una vez generado el árbol, realice módulos independientes para:
i. Obtener el número más grande.
ii. Obtener el número más chico.
iii. Obtener la cantidad de elementos.
iv. Informar los números en orden creciente.
v. Informar los números pares en orden decreciente.}

Program ejer8;
Type
  arbol = ^nodo;
  nodo = record
    dato:integer;
    Hi:arbol;
    Hd:arbol;
  end;



{========================= Comienzo Inciso A =========================}

Procedure Crear (VAR a:arbol; num:integer);
begin
  If (a = nil) then begin
    new(a);
    a^.dato:= num;
    a^.Hi:= nil;
    a^.Hd:= nil;
  end
  Else
    If (num < a^.dato.CODIGO) then
      Crear (a^.Hi,num)
    Else
      Crear (a^.Hd,num);
end;


Procedure CargarArbol (VAR a:arbol);
Var
  num:integer;
begin
  writeln('Ingrese un numero');
  readln(num);
  While (num <> 0) do begin
    Crear (a,num);
    writeln;
    writeln('Ingrese un numero');
    readln(num);
  end;  
end;

{========================= Fin Inciso A =========================}




{========================= Comienzo Inciso B.i =========================}

Function MAXIMO (a:arbol): integer;
begin
  If (a^.hd <> nil) then 
    MAXIMO:= MAXIMO (a^.Hd)
  else
  MAXIMO:= a^.dato;
end;

{========================= Fin Inciso B.i =========================}



{========================= Comienzo Inciso B.ii =========================}

Function MINIMO (a:arbol):integer;
begin
  If (a^.Hi <> nil) then 
    MINIMO:= MINIMO (a^.Hi)
  else    
    MINIMO:= a^.dato;
end;

{========================= Fin Inciso B.ii =========================}




{========================= Comienzo Inciso B.iii =========================}

Procedure SUMAR (a:arbol; VAR cant:integer);
begin
  If(a <> nil) then begin
     cant:= cant + 1;
     SUMAR (a^.Hd,cant);
     SUMAR (a^.Hi,cant);      
  end;
end;

{========================= Fin Inciso B.iii =========================}



{========================= Comienzo Inciso B.iv =========================}

Procedure ImprimeEnOrden (a:arbol);      //DE MENOR A MAYOR
begin
  If (a <> nil) then begin
     ImprimeEnOrden (a^.Hi);
     write (a^.dato,', ');
     ImprimeEnOrden (a^.Hd);
  end;
end;
{========================= Fin Inciso B.iv =========================}

 Procedure ImprimeEnOrden (a:arbol);      //DE MAYOR A MENOR
begin
  If (a <> nil) then begin
     ImprimeEnOrden (a^.Hd);
     write (a^.dato,', ');
     ImprimeEnOrden (a^.Hi);
  end;
end;

{========================= Comienzo Inciso B.v =========================}

Procedure PAR (a:arbol);  
begin
  If (a <> nil) then begin
    PAR (a^.Hd);
    If ((a^.dato MOD 2)=0) then
       writeln(a^.dato);
    PAR (a^.Hi);
  end;
End;

{========================= Fin Inciso B.v =========================}




{========================= PROGRAMA PRINCIPAL =========================}

VAR
  a:arbol;
  cant{,cant_par}:integer;
begin
  a:= nil;
  cant:= 0;
  {cant_par:= 0;}
  CargarArbol (a);
  writeln('El valor MAXIMO es: ',MAXIMO(a));
  writeln('El valor MINIMO es: ',MINIMO(a));
  SUMAR(a,cant);
  writeln('La cantidad de elementos en el arbol es: ',cant);
  ImprimeEnOrden(a);
  writeln;
  writeln('SE IMPRIMRAN LOS NUMEROS PARES EN FORMA DECRECIENTE');
  PAR(a); 
End.
