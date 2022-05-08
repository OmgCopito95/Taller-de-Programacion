program merge;

const
	cantE = 50;

type

   lista = ^nodo;
   nodo = record
			dato : string;
			sig : lista;
		end;
		
		
	estantes = array [1..cantE] of lista;




procedure minimo(var todos : estantes; var min : string);
var
   pos, i : integer;
begin
	min := 'zzz';
	pos := -1;
	
	for i:= 1 to cantE do					
		if (todos[i] <> nil) and (todos[i]^.dato <= min) then begin
			min := todos[i]^.dato; //ACTUALIZA MIN
			pos := i;	// GUARDA LA POS DE LA LISTA
		end;
	
	if (pos <> -1) then  //si encontré un minimo, avanzo en el estante
		todos[pos] := todos[pos]^.sig;
end;


procedure agregarAtras(var L,ult : lista; dato : string);
var
  aux : lista;
begin
   new(aux); aux^.dato := dato;
   if (l = nil) then
		L := aux
	else
		ult^.sig := aux;
	ult := aux;
end;

procedure insertarOrdenado(var L : lista; dato : string);
var
	aux,ant,act : lista;
	
begin
	act := L;
	ant := act;
	while (act<>nil) and (act^.dato < dato) do begin
		ant := act;
		act := act^.sig;
	end;
	
	new(aux); aux^.dato := dato;
	
	if (ant=act) then begin //primero de la lista, o lista vacía
		aux^.sig := L;
		L := aux;
	end 
	else begin
		ant^.sig := aux;
		aux^.sig := act;
	end;
		
	
end;
					//vector			//nueva lista que genera el merge
procedure merge(todos : estantes; var  eNuevo : lista);
var
   min : string;
   ult : lista;
   
begin
	eNuevo := nil; //inicializa la lista nueva
	
	minimo(todos,min);
	while (min <> 'zzz') do 
		begin
			agregarAtras(eNuevo,ult, min);
			minimo(todos,min);
		end;
	
end;


procedure obtenreTituloAleatorio(var s : string; var ant : integer);
begin
	ant := ant + Random(5);
	s := 'Titulo '+chr(ant)+chr(ant)+chr(ant);
end;

procedure leerTitulo(var s : string);
begin
	writeln('Ingrese el título del libro, o zzz para finalizar la carga');
	readln(s);
end;

procedure generarUnEstante(var estante : lista);
var
	ult : lista;
	titulo : string;
begin
		estante := nil;
		leerTitulo(titulo);
		while (titulo <> 'zzz') do begin
			//agregarAtras(estante,ult,titulo); //podria usar este modulo si los datos se leyerean en orden
			insertarOrdenado(estante,titulo);
			leerTitulo(titulo);
		end;
end;

procedure generarUnEstanteAleatorio(var estante : lista);
var
   primero,cant,i : integer;
   titulo : string;
   ult : lista;
begin
	cant := random(20); //vamos a generar un estante de a lo sumo 20 libros
	estante := nil;
	primero := 65;
	for i:= 1 to cant do begin
		obtenreTituloAleatorio(titulo,primero);
		
		insertarOrdenado(estante,titulo);
		//agregarAtras(estante,ult,titulo); //podria usar este modulo si los datos se leyerean en orden
	end;
end;

procedure ImprimirUnEstante(L : lista);
var
  cant : integer;
begin
	cant := 0;
	while (L <> nil) do begin
		cant := cant + 1;
		writeln('Libro ',cant, '  - Titulo: ',L^.dato);
		L := L^.sig;
	end;

end;

procedure imprimirEstantes(todos:estantes);
var
  i : integer;
begin

	for i:= 1 to cantE do begin
	    writeln('**************************');
		writeln('Estante número ' ,i);
		ImprimirUnEstante(todos[i]);
	end;

end;


procedure generarEstantes(var todos : estantes);
var
	i : integer;
begin
    randomize;
	for i:= 1 to cantE do
		//generarUnEstanteAleatorio(todos[i]);
		generarUnEstante(todos[i]);
end;


var
	todos : estantes;
	estanteNuevo : lista;
BEGIN

	generarEstantes(todos);
	imprimirEstantes(todos);
	merge(todos,estanteNuevo);
	writeln('Estante mergeado');
	imprimirUnEstante(estanteNuevo);
	
	
END.

