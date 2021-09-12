program ejer7pt1;

type

lista=^nodo;

nodo = record
	dato:integer;
	sig:lista;
	end;

procedure agregarAdelante(var l:lista; n:integer);
var
	nue: lista;
begin
	new(nue);
	nue^.dato := n;
	nue^.sig := l;
	l := nue;
end;


procedure descomponer ( var num:integer; var l:lista);
var
n:integer;
begin
	if (num = 0) or (num = 1) then
	    agregarAdelante (l,num)
	else
		begin
			n:=num mod 2;                   // SE PODRIA HACER SIN UTILIZAR UNA LISTA
			agregarAdelante (l,n);          //SI SE HACE UN AGREGAR ATRAS, ENTONCES LA LISTA SE DEBE IMPRIMIR AL REVES
			num:=num div 2;
			descomponer (num,l);
		end;

end;


procedure imprimir (l:lista);
begin
  IF (l <> nil) then
    begin
     write (l^.dato);
     imprimir (l^.sig);
    end;
 end;

var
l:lista;
num:integer;
BEGIN
l:=nil;
writeln ('ingrese el numero decimal que quiere pasar a binario');
readln (num);
while (num <> 0) do
	begin
		descomponer (num,l);
		writeln ('su representacion en binario es');
		imprimir (l);
		l:=nil;
		writeln ('---------------------------------');
		writeln ('ingrese el numero decimal que quiere pasar a binario');
		readln (num);
	end;
END.
