{Realizar un programa que lea números y que utilice un procedimiento recursivo que escriba el equivalente 
  en binario de un número decimal. El programa termina cuando el usuario ingresa el número 0 (cero).
 Ayuda: Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2. 
  ¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la próxima llamada recursiva?
    Ejemplo: si se ingresa 23, el programa debe mostrar: 10111.}



Program ejer7;

{================== Comienzo Convertir en BINARIO ==================}

Procedure BINARIO (num:integer);       // OPCION A
begin
  If (num < 2) then
    write('En BINARIO: ',num)  //1
  Else
    If (num DIV 2 <> 0) then begin
      BINARIO (num div 2);
    If (num >= 2) then 
        write (num MOD 2);
    end;
end;

{procedure BINARIO (num:integer);      //OPCION B
begin
	if(num < 2) then
      write(num)  
	else 
	  if(num div 2 <> 0) then begin  
      BINARIO(num DIV 2);
      write(num MOD 2);
	  end;	
end;}

{================== Fin Convertir en BINARIO ==================}




{================== PROGRAMA PRINCIPAL ==================}

VAR
 num:integer;
Begin
writeln('Ingrese un numero');
readln(num);
 while (num <> 0) do begin
  Binario (num);
  writeln;
  writeln('Ingrese un numero');
  readln(num);
 end;
End.