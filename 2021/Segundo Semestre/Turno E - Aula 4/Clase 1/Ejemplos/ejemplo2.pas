{

Ejemplo 2 - Practica 1 - Imperativo
* 
* Vector de registros - ordenacion por diferentes criterios - seleccion e insercion
   
}


program ejemplo2;

const
	dimF = 10;
	
type
	alumno = record
		dni: integer;
		nombre: string;
		apellido: string;
		codigo_alumno: integer;
	end;
	
	vector = array [1..dimF] of alumno;
	
// genera un string random y lo guarda en el parametro palabra
procedure randomString(StringLen:integer; var palabra:string);
var  str,Result:String; 
begin 
    str:='abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ'; 
    Result:=''; 
    repeat 
        Result:=Result+str[Random(Length(str))+1]; 
    until(Length(Result)=StringLen);
    palabra:=Result;
end;

//carga los datos del alumno de manera random
procedure leerAlumno(var a:alumno);
begin

	with a do begin
		dni:=random(1000); // 0-999
		randomString(10,nombre);
		randomString(10,apellido);
		codigo_alumno:=random(100);
	end;

end;

//carga un vector de alumnos hasta que aparezca el codigo 99 o se llene el vector
Procedure cargarVector (var v: vector; var dimL: integer);
var
   a:alumno;
   
begin
     leerAlumno(a);
     while (a.codigo_alumno <> 99)  and ( dimL < dimF ) do begin
           dimL := dimL + 1;
           v[dimL] := a;
           leerAlumno(a);
     end;
End;

// imprime el vector de manera linda :B
Procedure imprimirVector (v: vector; dimL: integer);
var
   i: integer;
begin
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        write(v[i].codigo_alumno, ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End; 

//imprime la info completa del vector 
procedure imprimirVectorSinForma(v: vector; dimL:integer);
var
	i:integer;
begin
	for i:=1 to dimL do begin
		write('DNI: ',v[i].dni,' ');
		write('Nombre: ',v[i].nombre,' ');
		write('Apellido: ',v[i].apellido,' ');
		write('Codigo: ',v[i].codigo_alumno,' ');
		writeln;
	end;
end;


// ORDENACION DE VECTORES POR SELECCION - ordena el vector de alumnos de menor a mayor por codigo de alumno
Procedure Ordenar ( var v: vector; dimLog: integer);
var
  i, j, p: integer;
  
  item: alumno;
  
begin
  for i:=1 to dimLog-1 do begin {busca el mínimo v[p] entre v[i] , ..., v[N] }
    p := i;
    for j := i+1 to dimLog do
      if v[j].codigo_alumno < v[p].codigo_alumno then	//ordena de menor a mayor. Para ordenar de mayor a menor, invertir el signo
        p:=j;
    {intercambia v[i] y v[p] }
    item := v[p];
    v[p] := v[i];
    v[i] := item;
  end;
end;



var 
	v: vector;
	dimL: integer;
BEGIN
	Randomize; //para que funcione el random
	dimL:=0;
	cargarVector(v,dimL);
	imprimirVector(v,dimL);
	imprimirVectorSinForma(v,dimL);
	Ordenar(v,dimL);
	imprimirVector(v,dimL);
	imprimirVectorSinForma(v,dimL);
END.

