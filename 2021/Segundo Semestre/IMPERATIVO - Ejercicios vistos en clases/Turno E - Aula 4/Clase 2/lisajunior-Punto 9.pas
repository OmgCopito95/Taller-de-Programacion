program punto9;

	type

		arbol = ^nodo;
		nodo = record
			dato: string;
			hi: arbol;
			hd: arbol;
		end;

//------------------------------------------------------------//
procedure crearArbol(var a: arbol);

	procedure crearNodo(var a: arbol; nombre: string);
	begin
		if(a = nil) then begin
			new(a);
			a^.dato:= nombre;
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else
			if(nombre < a^.dato) then
				crearNodo(a^.hi, nombre)
			else
				crearNodo(a^.hd, nombre);
	end;

var
	n: string;
begin
	write('INGRESE EL NOMBRE DE LA PERSONA: ');
	readln(n);
	while(n <> 'ZZZ') do begin
		crearNodo(a, n);
		write('INGRESE EL NOMBRE DE LA PERSONA: ');
		readln(n);
	end;
end;

//------------------------------------------------------------//
function buscarEnArbol(a: arbol; nombre: string): boolean;
begin
	if(a = nil) then
		buscarEnArbol:= false
	else begin
		if(nombre = a^.dato) then
			buscarEnArbol:= true
		else
			if(nombre < a^.dato) then
				buscarEnArbol:= buscarEnArbol(a^.hi, nombre)
			else
				buscarEnArbol:= buscarEnArbol(a^.hd, nombre);
	end;
end;

//------------------------------PROGRAMA PRINCIPAL------------------------------//
var
	a: arbol;
	nombreABuscar: string;
begin
	a:= nil;

	crearArbol(a);

	writeln();

//------------------------------//
	write('INGRESE EL NOMBRE DE LA PERSONA A BUSCAR: ');
	readln(nombreABuscar);

	if(buscarEnArbol(a, nombreABuscar)) then
		writeln('ENCONTRE EL NOMBRE DE LA PERSONA EN EL ARBOL')
	else
		writeln('NO SE ENCUENTRA EL NOMBRE DE LA PERSONA EN EL ARBOL');

	writeln();

//------------------------------//
	writeln();

	write('PRESIONE ENTER PARA CERRAR EL PROGRAMA');
	readln();
end.
