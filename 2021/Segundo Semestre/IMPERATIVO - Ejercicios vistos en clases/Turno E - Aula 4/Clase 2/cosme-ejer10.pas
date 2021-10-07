{Implementar un programa que contenga:
a. Un módulo que lea información de alumnos de Taller de Programación y almacene
en una estructura de datos sólo a aquellos alumnos que posean año de ingreso posterior
al 2010. Esta estructura debe estar ordenada por legajo y debe ser eficiente para la
búsqueda por dicho criterio. De cada alumno se lee legajo, apellido, nombre, DNI y año de
ingreso.
b. Un módulo que reciba la nueva estructura e informe el nombre y apellido de
aquellos alumnos cuyo legajo sea inferior a 15853.
c. Un módulo que reciba la nueva estructura e informe el nombre y apellido de
aquellos alumnos cuyo legajo esté comprendido entre 1258 y 7692.}

Program ejer10;

Type
  str20 = string [20];

  rAlumno = record
    legajo:integer;
    nombre: str20;
    apellido: str20;
    DNI: integer;
    AnioIngreso: integer;      
  end;

  arbol = ^nodo;
  nodo = record
     dato: rAlumno;
     Hi: arbol;
     Hd: arbol;
  end;


{================== Comienzo Inciso A ==================}

Procedure Crear (VAR a:arbol; ra:rAlumno);
begin
  If (a = nil) then begin
    new(a);
    a^.dato:= ra;
    a^.Hd:= nil;
    a^.Hi:= nil;    
  end
  Else
     If (ra.legajo < a^.dato.legajo) then
       Crear(a^.Hi,ra)
     Else
       Crear(a^.Hd,ra);
end;


Procedure LEER (VAR ra: rAlumno);
begin
  with ra do begin
     writeln('Ingrese el legajo');
     readln(legajo);
     If (legajo <> 0) then begin
        writeln('Ingrese el nombre');
        readln(nombre);
        writeln('Ingrese el apellido');
        readln(apellido); 
        writeln('Ingrese el DNI');
        readln(DNI);
        writeln('Ingrese el anio de ingreso');
        readln(AnioIngreso);
     end;
  end;
end;


Procedure CargarArbol (VAR a:arbol);
Var
 ra:rAlumno;
begin
  LEER(ra);
  While (ra.legajo <> 0) do begin
    If(ra.AnioIngreso > 2010) then
       Crear(a,ra);
    writeln;
    LEER(ra);
  end;
end;

{================== Fin Inciso A ==================}


{================== Comienzo Inciso C ==================}

Procedure Min_legajo (a:arbol; num:integer);
begin
    If (a <> nil) then begin
        If (a^.dato.legajo > inf) then
           if (a^.dato.legajo < sup) then begin
             writeln('Nombre: ',a^.dato.nombre,', Apellido: ',a^.dato.apellido);
             Min_legajo (a^.Hi,num);
             Min_legajo (a^.Hd,num);
           end
           else
             Min_legajo (a^.Hi,num);
        Else
           Min_legajo (a^.Hd,num);
    end;
end;

{================== Fin Inciso C ==================}




{================== PROGRAMA PRINCIPAL ==================}

VAR
  a:arbol;  
Begin
  CargarArbol(a);
  writeln;
  writeln('Los alumnos que se encuentran entre los legajos 1258 y 7692 son: ');
  EntreNumeros (a,1258,7692);
End.
