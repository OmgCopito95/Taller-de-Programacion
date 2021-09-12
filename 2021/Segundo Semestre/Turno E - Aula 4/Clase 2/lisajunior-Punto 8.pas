program punto8;

	type

		arbol = ^nodo;
		nodo = record
			dato: integer;
			HI: arbol;
			HD: arbol;
		end;

//------------------------------PUNTO A------------------------------//
procedure crearArbol(var a: arbol);

	procedure cargarNodo(var a: arbol; n: integer);
	begin
		if(a = nil) then begin
			new(a);
			a^.dato:= n;
			a^.HI:= nil;
			a^.HD:= nil;
		end
		else if(n < a^.dato) then
			cargarNodo(a^.HI, n)
		else
			cargarNodo(a^.HD, n);
	end;

var
	n: integer;
begin
	n:= random(16);
	writeln('Se ingrese el numero ', n);
	//write('Ingrese un numero: ');
	//readln(n);
	while(n <> 0) do begin
		cargarNodo(a, n);
		//write('Ingrese un numero: ');
		//readln(n);
		n:= random(16);
		writeln('Se ingrese el numero ', n);
	end;
end;

//------------------------------PUNTO B-I------------------------------//
function obtenerMayor(a: arbol; max: integer): integer;
begin
	if(a <> nil) then begin
		if(a^.dato > max) then
			max:= a^.dato;
		obtenerMayor:= obtenerMayor(a^.HI, max);      // CORREGIR, NO ESTÁ RECORRIENDO BIEN EL ARBOL
		obtenerMayor:= obtenerMayor(a^.HD, max)
	end
	else
		obtenerMayor:= max;
end;

//------------------------------PUNTO B-II------------------------------//
function obtenerMenor(a: arbol; min: integer): integer;
begin
	if(a <> nil) then begin
		if(a^.dato < min) then
			min:= a^.dato;
		obtenerMenor:= obtenerMenor(a^.HD, min);
		obtenerMenor:= obtenerMenor(a^.HI, min);       // CORREGIR, NO ESTÁ RECORRIENDO BIEN EL ARBOL
	end
	else
		obtenerMenor:= min;
end;

//------------------------------PUNTO B-III------------------------------//
function contarElementos(a: arbol; contador: integer): integer;
begin
	if(a <> nil) then begin
		contarElementos:= contarElementos(a^.HI, contador);      // CORREGIR, NO ESTÁ RECORRIENDO BIEN EL ARBOL
		contarElementos:= contarElementos(a^.HD, contador);
		contador:= contador + 1;
	end
	else
		contarElementos:= contador;
end;

//------------------------------PROGRAMA PRINCIPAL------------------------------//
var
	a: arbol;
	max, min, contador: integer;
begin
	a:= nil;
	max:= -1;
	min:= 9999;
	contador:= 0;

//------------------------------PUNTO A------------------------------//
	crearArbol(a);

	writeln();

//------------------------------PUNTO B-I------------------------------//
	writeln('El numero mas grande del arbol es el ', obtenerMayor(a, max));

	writeln();

//------------------------------PUNTO B-II------------------------------//
	writeln('El numero mas chico del arbol es el ', obtenerMenor(a, min));

	writeln();

//------------------------------PUNTO B-III------------------------------//
	writeln('La cantidad de elementos que tiene el arbol es ', contarElementos(a, contador));

	writeln();

	write('PRESIONE ENTER PARA CERRAR EL PROGRAMA');
	readln();
end.




