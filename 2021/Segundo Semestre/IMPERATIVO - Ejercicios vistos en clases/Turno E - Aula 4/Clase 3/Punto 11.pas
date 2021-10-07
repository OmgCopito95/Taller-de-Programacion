program punto1;

	const

		dimF = 8;

	type

		generos = 1..dimF;

		pelicula = record
			codPeli: integer;
			codGenero: generos;
			puntaje: real;
		end;

		lista = ^nodo;
		nodo = record
			dato: pelicula;
			sig: lista;
		end;

		listaNueva = ^nodoLN;    //deberia guardar el registro completo. no hace falta nuevo type
		nodoLN = record
			dato: integer;
			sig: listaNueva;
		end;

		vGeneros = array [1..dimF] of lista;

//------------------------------------------------------------//
procedure inicializarVector(var v: vGeneros);
var
	i: integer;
begin
	for i:= 1 to dimF do
		v[i]:= nil;
end;

//------------------------------PUNTO A------------------------------//
procedure cargarVectorListas(var v: vGeneros);

	procedure leerPelicula(var p: pelicula);
	begin
		with p do begin

			codPeli:= random(5)-1;
			writeln('CODIGO DE LA PELICULA: ', codPeli);

			if(codPeli <> -1) then begin

				codGenero:= random(8)+1;
				writeln('GENERO DE LA PELICULA: ', codGenero);

				puntaje:= random(11);
				writeln('PUNTAJE QUE OBTUVO LA PELICULA: ', puntaje:2:2);

				writeln();
			end;
		end;
	end;

	procedure insertarOrdenado(var l: lista; p: pelicula);
	var
		nue, ant, act: lista;
	begin
		new(nue);
		nue^.dato:= p;
		ant:= l;
		act:= l;
		while((act <> nil) and (p.codPeli > l^.dato.codPeli)) do begin    // corregir
			act:= act;
			act:= act^.sig;
		end;
		if(ant = act) then
			l:= nue
		else
			ant^.sig:= nue;
		nue^.sig:= act;
	end;

var
	p: pelicula;
begin
	writeln('SE LEEN LOS DATOS DE CADA PELICULA');
	writeln();
	leerPelicula(p);
	while(p.codPeli <> -1) do begin
		insertarOrdenado(v[p.codGenero], p);
		leerPelicula(p);
	end;
end;

//------------------------------PUNTO B------------------------------//
procedure merge(v: vGeneros; var lnueva: listaNueva);

	procedure minimo(var v: vGeneros; var min: integer);
	var
		pos, i: integer;
	begin
		min:= 99999;
		pos:= -1;
		for i:= 1 to dimF do begin
			if(v[i] <> nil) then begin
				if(v[i]^.dato.codPeli <= min) then begin
					min:= v[i]^.dato.codPeli;
					pos:= i;
				end;
			end;
		end;
		if(pos <> -1) then          //falta guardarse todos los datos del registro
			v[pos]:= v[pos]^.sig;
	end;

	procedure agregarAdelante(var l: listaNueva; min: integer);
	var
		nue: listaNueva;
	begin
		new(nue);
		nue^.dato:= min;
		nue^.sig:= l;
		l:= nue;
	end;

var
	min: integer;
begin
	lNueva:= nil;
	minimo(v, min);
	while(min <> 99999) do begin
		agregarAdelante(lNueva, min);
		minimo(v, min);
	end;
end;

procedure imprimirLista(l: listaNueva);
begin
	while(l <> nil) do begin
		writeln('CODIGO DE LA PELICULA: ', l^.dato);
		l:= l^.sig;
	end;
end;

//------------------------------PROGRAMA PRINCIPAL------------------------------//
var
	vector: vGeneros;
	lNueva: listaNueva;
begin
	randomize;

	inicializarVector(vector);

//------------------------------PUNTO A------------------------------//
	cargarVectorListas(vector);

	writeln();

//------------------------------PUNTO B------------------------------//
	merge(vector, lNueva);

	imprimirLista(lNueva);

	writeln();	

	write('PRESIONE ENTER PARA CERRAR EL PROGRAMA');
	readln();
end.
