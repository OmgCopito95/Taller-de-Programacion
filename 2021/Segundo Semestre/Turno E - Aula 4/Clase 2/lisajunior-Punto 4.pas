program punto4;

	type

		lista = ^nodo;
		nodo = record
			dato: integer;
			sig: lista;
		end;


//------------------------------PUNTO A------------------------------//
procedure crearLista(var l: lista);

	procedure agregarAdelante(var l: lista; n: integer);
	var
		nue: lista;
	begin
		new(nue);
		nue^.dato:= n;
		nue^.sig:= l;
		l:= nue;
	end;

var
	n: integer;
begin
	write('Ingrese un numero: ');
	readln(n);
	while(n <> -1) do begin
		agregarAdelante(l, n);
		write('Ingrese un numero: ');
		readln(n);
	end;
end;

//------------------------------PUNTO B------------------------------//
procedure buscarMinimo(l: lista; var min: integer);
begin

    if (l<>nil)then
    begin
		if(l^.dato < min) then
			min:= l^.dato;
		l:= l^.sig;
		buscarMinimo(l, min);
	end;
end;

function buscarMinF(l:lista;min:integer): integer;
begin

    if(l=nil)then
      buscarMinF:=min
    else begin
        if(l^.dato < min) then
           min:= l^.dato;
        l:=l^.sig;
        buscarMinF:=buscarMinF(l,min);
    end;


end;

function maximo (l:lista; max:integer):integer;     //MAX VIENE INICIALIZADO DESDE DONDE SE LO LLAME
begin
  if(l <> nil) then begin
    if(l^.elem > max) then begin
      max := l^.elem;
    end;
    maximo := maximo(l^.sig,max);
  end
  else begin
    maximo := max;
  end;
end;



//------------------------------PUNTO C------------------------------//
procedure buscarMaximo(l: lista; var max: integer);
begin
	if(l <> nil) then begin
		if(l^.dato > max) then
			max:= l^.dato;
		l:= l^.sig;
		buscarMaximo(l, max);
	end;
end;

//------------------------------PUNTO D------------------------------//
function buscarEnLista(l: lista; n: integer): boolean;
begin
	if(l = nil) then
		buscarEnLista:= false    //caso base 1 - no lo encontre
	else
        if(l^.dato = n) then      //caso base 2 - encontre el elemento
		   buscarEnLista:= true
	else begin
		l:= l^.sig;
		buscarEnLista:= buscarEnLista(l, n);
	end;
end;

var
	l: lista;
	valMin, valMax, nBuscar: integer;
begin
	l:= nil;
	valMin:= 9999;
	valMax:= -1;

	crearLista(l); //PUNTO A

	buscarMinimo(l, valMin); //PUNTO B

	writeln('El valor minimo de la lista es: ', valMin); //PUNTO B

	buscarMaximo(l, valMax); //PUNTO C

	writeln('El valor minimo de la lista es: ', valMax); //PUNTO C

	writeln();

	write('Ingrese un numero a buscar en la lista: ');
	readln(nBuscar);
	if(buscarEnLista(l, nBuscar)) then
		writeln('EL ELEMENTO SE ENCUENTRA EN LA LISTA')
	else
		writeln('EL ELEMENTO NO SE ENCUENTRA EN LA LISTA');

	writeln();

	write('PRESIONE ENTER PARA CERRAR EL PROGRAMA');
	readln();
end.
