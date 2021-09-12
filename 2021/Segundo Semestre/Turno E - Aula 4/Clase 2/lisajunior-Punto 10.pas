program punto10;

	type

		alumno = record
			legajo: integer;
			apellido: string;
			nombre: string;
			dni: integer;
			anioIngreso: integer;
		end;

		arbol = ^nodo;
		nodo = record
			dato: alumno;
			hi: arbol;
			hd: arbol;
		end;

//------------------------------PUNTO A------------------------------//
procedure crearArbol(var a: arbol);

	procedure leerAlumno(var al: alumno);
	begin
		with al do begin
			write('Ingrese el anio de ingreso del alumno: ');
			readln(anioIngreso);
			if(anioIngreso > 2010) then begin
				write('Ingrese el legajo del alumno: ');
				readln(legajo);
				write('Ingrese el apellido del alumno: ');
				readln(apellido);
				write('Ingrese el nombre del alumno: ');
				readln(nombre);
				write('Ingrese el DNI del alumno: ');
				readln(dni);
				writeln();
			end;
			writeln();
		end;
	end;

	procedure crearNodo(var a: arbol; al: alumno);
	begin
		if(a = nil) then begin
			new(a);
			a^.dato:= al;
			a^.hi:= nil;
			a^.hd:= nil;
		end
		else
			if(al.legajo < a^.dato.legajo) then
				crearNodo(a^.hi, al)
			else
				crearNodo(a^.hd, al);
	end;
	
var
	al: alumno;
begin
	writeln('SE LEEN LOS DATOS DE CADA ALUMNO');
	leerAlumno(al);
	while(al.anioIngreso > 2010) do begin
		crearNodo(a, al);
		leerAlumno(al);
	end;
end;

//------------------------------PUNTO B------------------------------//
procedure imprimirLegajoInferior(a: arbol; n: integer);
begin
	if(a <> nil) then begin
		if(a^.dato.legajo < n) then begin
			writeln('Nombre del alumno: ', a^.dato.nombre);
			writeln('Apellido del alumno: ', a^.dato.apellido);
			imprimirLegajoInferior(a^.hi, n);
			imprimirLegajoInferior(a^.hd, n);
		end
		else
			imprimirLegajoInferior(a^.hi, n);
	end;
end;

//------------------------------PUNTO c------------------------------//
procedure imprimirLegajoEntre(a: arbol; n1, n2: integer);
begin
	if(a <> nil) then begin
		if((a^.dato.legajo > n1) and (a^.dato.legajo < n2)) then begin
			writeln('Nombre del alumno: ', a^.dato.nombre);
			writeln('Apellido del alumno: ', a^.dato.apellido);
			imprimirLegajoEntre(a^.hi, n1, n2);
			imprimirLegajoEntre(a^.hd, n1, n2);
		end
		else begin
			if(a^.dato.legajo < n1) then
				imprimirLegajoEntre(a^.hd, n1, n2);  //FALTARIA UN ELSE
			if(a^.dato.legajo > n2) then
				imprimirLegajoEntre(a^.hi, n1, n2);
		end;
	end;
end;


//------------------------------PROGRAMA PRINCIPAL------------------------------//
var
	a: arbol;
begin
	a:= nil;

//------------------------------PUNTO A------------------------------//
	crearArbol(a);

	writeln();
//------------------------------PUNTO B------------------------------//
	writeln('NOMBRE Y APELLIDO DE LOS ALUMNOS CON LEGAJO INFERIOR A 15853');
	imprimirLegajoInferior(a, 15853);

	writeln();

//------------------------------PUNTO c------------------------------//
	writeln('NOMBRE Y APELLIDO DE LOS ALUMNOS CON LEGAJO COMPRENDIDO ENTRE 1258 Y 7692');
	imprimirLegajoEntre(a, 1258, 7692);

//------------------------------------------------------------//
	writeln();

	write('PRESIONE ENTER PARAR CERRAR EL PROGRAMA');
	readln();
end.
