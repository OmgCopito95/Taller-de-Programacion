program punto13;

	const

		dimF = 7;

	type

		dias = 1..dimF;

		entrada = record
			dia: dias;
			codigoObra: integer;
			asiento: integer;
			monto: real;
		end;

		lista = ^nodo;
		nodo = record
			dato: entrada;
			sig: lista;
		end;

		regNuevo = record
			entradasVendidas: integer;
			codigo: integer;
		end;

		listaNueva = ^nNuevo;
		nNuevo = record
			dato: regNuevo;
			sig: listaNueva;
		end;

		vDias = array [dias] of lista;

//------------------------------------------------------------//
procedure inicializarVectorListas(var v: vDias);
var
	i: integer;
begin
	for i:= 1 to dimF do
		v[i]:= nil;
end;

//------------------------------PUNTO A------------------------------//
procedure cargarVectorListas(var v: vDias);

	procedure leerEntrada(var e: entrada);
	begin
		with e do begin
			codigoObra:= random(4);
			writeln('CODIGO DE LA OBRA: ', codigoObra);
			
			if(codigoObra <> 0) then begin

				dia:= random(7)+1; //random(n) genera valores que van desde 0 hasta n-1. Si queremos generar los valores desde 1 hasta n, hacemos random(n) + 1 con n inclusive
				writeln('DIA DE LA OBRA: ', dia);
				
				asiento:= random(51);
				writeln('ASIENTO: ', asiento);
				
				monto:= random(501);
				writeln('MONTO: ', monto:2:2);
				
				writeln();
			end;
		end;
	end;

	procedure insertarOrdenado(var l: lista; e: entrada);
	var
		nue, ant, act: lista;
	begin
		new(nue);
		nue^.dato:= e;
		ant:= l;
		act:= l;
		while((act <> nil) and (e.codigoObra > act^.dato.codigoObra)) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if(ant = act) then
			l:= nue
		else
			ant^.sig:= nue;
		nue^.sig:= act;
	end;


var
	e: entrada;
begin
	writeln('SE INGRESAN LOS DATOS DE CADA ENTRADA');
	writeln();
	leerEntrada(e);
	while(e.codigoObra <> 0) do begin
		insertarOrdenado(v[e.dia], e);
		leerEntrada(e);
	end;
end;

//------------------------------PUNTO B - OPCIÓN 1------------------------------//
{procedure merge(v: vDias; var l: listaNueva);

	procedure minimo(var v: vDias; var min: entrada);
	var
		i, posMin: integer;
	begin
		min.codigoObra:= 9999;
		posMin:= -1;
		for i:= 1 to dimF do begin
			if(v[i] <> nil) then begin
				if(v[i]^.dato.codigoObra < min.codigoObra) then begin
					min.codigoObra:= v[i]^.dato.codigoObra;
						posMin:= i;
				end;
			end;
		end;
		if(posMin <> -1) then begin
			min:= v[posMin]^.dato;
			v[posMin]:= v[posMin]^.sig;
		end;
	end;

	procedure agregarAtras(var l, ult: listaNueva; codAct: regNuevo);
	var
		nue: listaNueva;
	begin
		new(nue);
		nue^.dato:= codAct;
		nue^.sig:= nil;
		if(l <> nil) then
			ult^.sig:= nue
		else
			l:= nue;
		ult:= nue;
	end;

var
	ult: listaNueva;
	min: entrada;
	codAct: regNuevo;
begin
	l:= nil;
	minimo(v, min);
	while(min.codigoObra <> 9999) do begin
		codAct.entradasVendidas:= 0;
		codAct.codigo:= min.codigoObra;
		while((min.codigoObra <> 9999) and (min.codigoObra = codAct.codigo)) do begin
			codAct.entradasVendidas:= codAct.entradasVendidas + 1;
			minimo(v, min);
		end;
		agregarAtras(l, ult, codAct);
	end;
end;}

//------------------------------PUNTO B - OPCIÓN 2------------------------------//
procedure merge(v: vDias; var l: listaNueva);

	procedure minimo(var v: vDias; var min: integer);
	var
		i, posMin: integer;
	begin
		min:= 9999;
		posMin:= -1;
		for i:= 1 to dimF do begin
			if(v[i] <> nil) then begin
				if(v[i]^.dato.codigoObra < min) then begin
					min:= v[i]^.dato.codigoObra;
					posMin:= i;
				end;
			end;
		end;
		if(posMin <> -1) then begin
			v[posMin]:= v[posMin]^.sig;
		end;
	end;

	procedure agregarAtras(var l, ult: listaNueva; codAct: regNuevo);
	var
		nue: listaNueva;
	begin
		new(nue);
		nue^.dato:= codAct;
		nue^.sig:= nil;
		if(l <> nil) then
			ult^.sig:= nue
		else
			l:= nue;
		ult:= nue;
	end;

var
	ult: listaNueva;
	min: integer;
	codAct: regNuevo;
begin
	l:= nil;
	minimo(v, min);
	while(min <> 9999) do begin
		codAct.entradasVendidas:= 0;
		codAct.codigo:= min;
		while((min <> 9999) and (min = codAct.codigo)) do begin
			codAct.entradasVendidas:= codAct.entradasVendidas + 1;
			minimo(v, min);
		end;
		agregarAtras(l, ult, codAct);
	end;
end;

procedure imprimirMerge(l: listaNueva);
begin
	if(l <> nil) then begin
		writeln('SE IMPRIME LA LISTA MERGE');
		writeln();
		while(l <> nil) do begin
			writeln('DEL CODIGO ', l^.dato.codigo, ' SE VENDIO ', l^.dato.entradasVendidas, ' ENTRADAS.');
			l:= l^.sig;
		end;
	end
	else
		writeln('NO SE VENDIERON ENTRADAS, F EN EL CHAT');
end;

//------------------------------PROGRAMA PRINCIAL------------------------------//
var
	vector: vDias;
	lNueva: listaNueva;
begin
	randomize;

	inicializarVectorListas(vector);

//------------------------------PUNTO A------------------------------//
	cargarVectorListas(vector);

	writeln();

//------------------------------PUNTO B------------------------------//
	merge(vector, lNueva);

	imprimirMerge(lNueva);

//------------------------------------------------------------//
	writeln();

	write('PRESIONE ENTER PARA CERRAR EL PROGRAMA');
	readln();
end.


