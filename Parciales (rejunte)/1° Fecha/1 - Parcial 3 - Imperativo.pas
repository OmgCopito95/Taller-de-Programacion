Program parcial3;
CONST
	SUCURSALES = 5;
	VENTAS = 200;
	CORTE = -1;
Type

	venta = record
		codigoProducto : integer;
		cantidadVendida : integer;
		monto : real;
	end;
	
	vector_v = array[1..VENTAS] of venta;
    
    suc = record
		dimL:integer;
		vectorVentas:vector_v;
	end;
    
    vectorSucursales = array[1..SUCURSALES] of suc;
    
    
    
    
    cantidadAcumulada = record
		codigoProducto : integer;
		cantidadTotal : integer;
	end;
    
    lista2 = ^nodo2;
    nodo2 = record
		dato : cantidadAcumulada;
		sig : lista2;
	end;

{Procedimientos y Funciones}
Procedure leerVenta(var v:venta);
Begin
	writeln('Ingrese el codigo del producto');
	readln(v.codigoProducto);
	if (v.codigoProducto <> CORTE) then begin
		writeln('Ingrese la cantidad vendida');
		readln(v.cantidadVendida);
		writeln('Ingrese el monto');
		readln(v.monto);
	end;
End;

Procedure inicializarVectorDeListas(var v:vectorSucursales);
Var
	i : integer;
Begin
	for i:= 1 to SUCURSALES do begin
		v[i] := nil;  //DIML EN CERO
	end;
End;

Procedure agregarAlFinal(var l:lista ; dato:venta);
Var
	aux,act,ant : lista;
Begin
	new(aux);
	aux^.dato := dato;
	aux^.sig := nil;
	
	if (l = nil) then begin
		l := aux;
	end
	else begin
		act := l;
		ant := l;
		
		while (act <> nil) do begin
			ant := act;
			act := act^.sig;
		end;
		
		ant^.sig := aux;
	end;
End;

Procedure cargarSucursales(var s:vectorSucursales);
Var
	v : venta;
	i : integer;
	aux : integer;
Begin	
	for i := 1 to SUCURSALES do begin
		writeln('S U C U R S A L ',i);
		
		aux := 0;
		leerVenta(v);
		
		while ((aux <= VENTAS) and (v.codigoProducto <> CORTE)) do begin
			aux := aux + 1; //SERIA DIML DEL VECTOR DE VENTAS
			agregarAlFinal(s[i],v);   //AGREGAR EN EL VECTOR DE LA SUCURSAL S[I].DIMl:=AUX
			leerVenta(v);													S[I].VECTOR_VENTAS[DIML]:=V
		end;
		
	end;
End;

Procedure agregarAlFinal(var pri:lista2 ; var ult:lista2 ; dato:cantidadAcumulada);
Var
	nue: lista2;
Begin
	new(nue);
	nue^.dato := dato;
	nue^.sig := nil;
	if (pri = nil) then
		pri := nue
	else
		ult^.sig := nue;
	ult:= nue;	
end;

Procedure determinarMinimo(var v:vectorSucursales ; var min:venta);
Var
	i : integer;
	pos : integer;
Begin
	min.codigoProducto := 9999;
	for i:= 1 to SUCURSALES do begin
		if (v[i] <> nil) then begin
			if (v[i]^.dato.codigoProducto < min.codigoProducto) then begin
				pos := i;
				min := v[pos]^.dato;
			end;
		end;
	end;
	
	if (min.codigoProducto <> 9999) then begin
		v[pos] := v[pos]^.sig;
	end;
End;

Procedure mergeAcumulador (s:vectorSucursales ; var l:lista2);
Var
	min : venta;
	ult : lista2;
	actual : cantidadAcumulada;
Begin
	determinarMinimo(s,min);
	
	while (min.codigoProducto <> 9999) do begin
		actual.codigoProducto := min.codigoProducto;
		actual.cantidadTotal := 0;
		
		while ((min.codigoProducto <> 9999) and (actual.codigoProducto = min.codigoProducto)) do begin
			actual.cantidadTotal := actual.cantidadTotal + min.cantidadVendida;
			determinarMinimo(s,min);
		end;
		
		agregarAlFinal(l,ult,actual);
	end;
End;

Function evaluarLista (l:lista2) : integer;
Begin
	if (l = nil) then
		evaluarLista := 0
	else begin
		if (l^.dato.cantidadTotal > 500) then
			evaluarLista := 1 + evaluarLista(l^.sig);
	end;
End;


{PROGRAMA PRINCIPAL}
VAR
	s : vectorSucursales;
	l : lista2;
BEGIN
	inicializarVectorDeListas(s);
	cargarSucursales(s);
	
	mergeAcumulador(s,l);												// a.
	
	evaluarLista(l);													// b.
END.
