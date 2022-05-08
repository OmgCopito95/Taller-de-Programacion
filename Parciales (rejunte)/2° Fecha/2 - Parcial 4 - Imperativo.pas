Program parcial4;
CONST
	SUCURSALES = 5;
	CORTE = -1;
Type	
	asistencia = record
		codigoSucursal : integer;
		dniCliente : integer;
		codigoCliente : integer;
		fecha : String;
		cantMinutos : double;
	end;
	
	lista = ^nodo;
	nodo = record
		dato : asistencia;
		sig : lista;
	end;
	
	vectorSucursales = array [1..SUCURSALES] of lista;
	
	cantidadAcumulada = record
		dni : integer;
		cantidadTotal : integer;
	end;
	
	arbol = ^nodoA;
	nodoA = record
		dato : cantidadAcumulada;
		HI : arbol;
		HD : arbol;
	end;

{Procedimientos y Funciones}
Procedure inicializarVectorDeListas(var v:vectorSucursales);
Var
	i : integer;
Begin
	for i:= 1 to SUCURSALES do begin
		v[i] := nil;
	end;
End;

Procedure leerAsistencia(var a:asistencia);
Begin
	readln(a.codigoCliente);
	if (a.codigoCliente <> CORTE) then begin
		readln(a.codigoSucursal);
		readln(a.dniCliente);
		readln(a.fecha);
		readln(a.cantMinutos);
	end;
End;

Procedure insertarOrdenado(var l:lista; dato:asistencia);
Var
	act, prev, nue: lista;
Begin
	new(nue);
	nue^.dato := dato;
	nue^.sig := nil;

	act:= l;
	while (act <> nil) and (dato.codigoCliente > act^.dato.codigoCliente) do begin
		prev:= act;
		act:= act^.sig;
	end;

	nue^.sig:= act;
	
	if l = act then
		l:= nue
	else
		prev^.sig:= nue;
End;

Procedure cargarAsistencias(v : vectorSucursales);
Var
	a : asistencia;
Begin
	leerAsistencia(a);
	while (a.codigoCliente <> CORTE) do begin
		insertarOrdenado(v[a.codigoSucursal],a);
		leerAsistencia(a);
	end;
End;

Procedure insertarEnArbol (var a:Arbol ; dato:cantidadAcumulada);
Begin
	if (a = nil) then begin
		new(a);
		a^.dato := dato;
		a^.HI := nil;
		a^.HD := nil;
	end
	else
		if (a^.dato.dni <> dato.dni) then
			if (a^.dato.dni > dato.dni) then
				insertarEnArbol(a^.HI,dato)
			else
				insertarEnArbol(a^.HD,dato)
End;

Procedure determinarMinimo(var v:vectorSucursales ; var min:asistencia);
Var
	i : integer;
	pos : integer;
Begin
	min.dniCliente := 9999;
	for i:= 1 to SUCURSALES do begin
		if (v[i] <> nil) then begin
			if (v[i]^.dato.dniCliente < min.dniCliente) then begin
				pos := i;
				min := v[pos]^.dato;
			end;
		end;
	end;
	
	if (min.dniCliente <> 9999) then begin
		v[pos] := v[pos]^.sig;
	end;
End;

Procedure mergeAcumulador (v:vectorSucursales ; var a:arbol);
Var
	min : asistencia;
	actual : cantidadAcumulada;
Begin
	determinarMinimo(v,min);
	
	while (min.dniCliente <> 9999) do begin
		actual.dni := min.dniCliente;
		//ACTUAL.CODIGO := MIN.CODIGOcLIENTE
		actual.cantidadTotal := 0;
		
		while ((min.dniCliente <> 9999) and (actual.dni = min.dniCliente)) do begin
			actual.cantidadTotal := actual.cantidadTotal + 1;
			determinarMinimo(v,min);
		end;
		
		insertarEnArbol(a,actual);
	end;
End;

{PROGRAMA PRINCIPAL}
VAR
	v : vectorSucursales;
	a : arbol;
BEGIN
	inicializarVectorDeListas(v);
	cargarAsistencias(v);
	
	mergeAcumulador(v,a);
	
END.
