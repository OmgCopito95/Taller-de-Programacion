Program untitled;
CONST
	EMPLEADOS = 250;
Type
	subCategoria = 1..20;

	empleado = record
		legajo : integer;
		dni : integer;
		categoria : subCategoria;
		ingreso : integer;
	end;
	
	arbol = ^nodoA;
	nodoA = record
		dato : empleado;
		HI : arbol;
		HD : arbol;
	end;
	
	datosVector = record
		dni : integer;
		legajo : integer;
	end;
	
	lista = ^nodo;
	nodo = record
		dato : datosVector;
		sig : lista;
	end;
	
	vector = array [subCategoria] of lista;

{Procedimientos y Funciones}
Procedure OrdenarPorInsercion(var v:vector ; dimL:integer);
Var
	i : integer;
	j : integer;
	actual : datosVector;
Begin
	for i := 2 to dimL do begin
	
		actual := v[i]^.dato;
		j := i - 1;
		
		while ((j>0) and (v[j]^.dato.dni > actual.dni)) do begin		// Cambiar criterio de orden
			v[j+1] := v[j];
			j := j - 1;
		end;
		
		v[j+1]^.dato := actual;
	end;
End;

procedure evaluarArbol(a:arbol ; dniA,dniB,nroCategoria:integer ; var v:vector);
Begin
	while (a <> nil) do begin
		if (a^.dato.dni >= dniB) then
			if (a^.dato.dni <= dniA) then begin
				
				...
				...
				
			end
			else
				a := a^.HI
		else
			a := a^.HD;	
	end;
End;


{PROGRAMA PRINCIPAL}
VAR
	a : arbol;
	dniA, dniB, nroCategoria : integer;
	v : vector;
BEGIN
	cargarArbol(a);		//Se dispone segun el enunciado
	evaluarArbol(a,dniA,dniB,nroCategoria,v);
END.
