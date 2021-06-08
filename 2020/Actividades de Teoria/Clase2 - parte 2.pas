program Clase2Arboles;

Type
  arbol = ^nodo;

  nodo = record
   dato: integer;
   HI: arbol;
   HD: arbol;
  end;

Procedure crearNodo (var A:arbol; num:integer);
Begin
  if (A = nil) then
   begin
      new(A);
      A^.dato:= num; A^.HI:= nil; A^.HD:= nil;
   end
   else
    if (num < A^.dato) then crearNodo(A^.HI,num)
    else crearNodo(A^.HD,num)   
End;

Procedure preOrden ( a : arbol );
begin
   if ( a<> nil ) then begin
    write (a^.dato);
    preOrden (a^.HI);
    preOrden (a^.HD);
   end;
end;
Procedure posOrden ( a : arbol );
begin
   if ( a<> nil ) then begin
    posOrden (a^.HI);
    posOrden (a^.HD);
    write (a^.dato);
   end;
end;
Procedure enOrden ( a : arbol );
begin
   if ( a<> nil ) then begin
    enOrden (a^.HI);
    write (a^.dato);
    enOrden (a^.HD);
   end;
end;
Function Buscar (a:arbol; x:integer): arbol; 
 begin
  if (a=nil) then Buscar:=nil
  else if (x= a^.dato) then Buscar:=a
       else 
        if (x < a^.dato) then Buscar:=Buscar(a^.hi ,x)
        else  Buscar:=Buscar(a^.hd ,x)
end;



procedure crearArbol(var a : arbol);
var
  num,i : integer;
begin
	Randomize;
	for i:=1 to 10 do begin
		writeln('Ingrese un numero para agregar al arbol');
		//readln(num);
		num := Random(100);
		writeln('Agregando el valor ',num,' al arbol');
		crearNodo(a,num);
		
	end;
end;

function sumarArbol(a:arbol):integer;
begin
	if (a=nil) then
		sumarArbol := 0
	else
		sumarArbol := a^.dato+ sumarArbol(a^.hi) + sumarArbol(a^.hd) ;
end;

function Max(x1,x2 : integer) : integer;
begin
   if x1 >= x2 then max := x1
   else max := x2;
end;

function maximo (a : arbol):integer; 
begin
    if (a=nil) then
		maximo := -32767
	else 
	 if (a^.hd = nil) then
		maximo := a^.dato
		else
			maximo := maximo(a^.hd);
end;
 
var
   a : arbol;
begin
  a := nil;
  crearArbol(a);
  writeln('****************');
  writeln('La suma de todos los nodos del arbol es ' , sumarArbol(a));
  writeln('El valor maximo del arbol es ' ,maximo(a) );

end.
