program Clase2;
type
  lista = ^nodo;
  nodo = record
	num : integer;
	sig : lista;
	end;

procedure agregarAdelante(var L : lista; num : integer);
var
  aux : lista;
begin
  new (aux);
  aux^.num := num;
  aux^.sig := L;
  L := aux;
end;

procedure cargarLista (var L : lista);
var
  i,num : integer;
begin
  L := NIL;
  for i := 1 to 8 do begin
	writeln('Ingrese un numero'); readln(num);
	agregarAdelante(L,num);
  end;
end;


//imprimie la lista de adelante hacia atrás
procedure imprimirListaDirecto(L : lista);
begin
  if (L <> nil) then begin
     writeln(L^.num);
     imprimirListaDirecto(L^.sig);
  end;
end;

//imprimie la lista de atrás hacia adelante
procedure imprimirListaReverso(L : lista);
var 
  numaux:integer;
begin
  if (L <> nil) then begin
     
     imprimirListaReverso(L^.sig);
     writeln(L^.num);
  end;
end;

procedure imprimirDigitos(num : integer);
begin
  if (num > 0) then begin               
	writeln(num MOD 10);
	imprimirDigitos(num DIV 10);                                    
	
  end;
end;

procedure descomponerNumeros;
var
  num : integer;
begin
	writeln('Ingrese un numero, o cero para cerrar');
	readln(num);
	while (num <> 0) do begin
		imprimirDigitos(num);
		writeln('Ingrese otro numero, o cero para cerrar');
		readln(num);
	end;
end;

var
   L : lista;
begin

	writeln('Actividad 2: recursividad con DIV y MOD');
	descomponerNumeros;
end.
