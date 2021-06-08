program Clase1;
const
  CANTMAX=20;
type
  rangovector = 1..CANTMAX;
  vector = array[rangovector] of integer;
  
  lista = ^nodo;
  nodo = record
			num : integer;
			sig : lista;
		end;
  
procedure leerNumero(var x : integer);
begin
   writeln('Ingrese un numero entero');
   readln(x);
   if (x = 0) then
	writeln('Ingresó el cero - fin de la lectura de números');
end;  

{ carga el vector hasta que se lee el número 0 o se hayan leído 20 números }
procedure cargarVector(var v : vector; var i : integer);
var
  num : integer;
begin
   writeln('Inicia la carga del vector. Le ingresarn números hasta que se lee el 0 o hasta un máximo de 20 números');
   leerNumero(num);
   while (num <> 0) and (i < CANTMAX) do begin
      i := i + 1;
      v[i] := num;
      leerNumero(num);
   end;
end;

procedure imprimirElemento(pos : rangoVector; valor:integer);
begin
  writeln('V[ ',pos,' ] => ',valor);
end;

{ imprime el contenido del arreglo }
procedure imprimirArreglo(v : vector; dimL : rangovector);
var
  i : rangovector;
begin
  for i:=1 to dimL do 
	imprimirElemento(i,v[i]);
end;

{ retorna la posicion de num en el vector V, o -1 si num no se encuentra en V}
function pos(num : integer; v:vector; dimL : rangovector) : integer;
var
  i : integer;
begin
  i := 1;
  while (i <= dimL) and (v[i] <> num) do
     i := i + 1;
  
  if (i > dimL) then   
	i := -1;

   pos := i;	
end;

{ Intenta eliminar num del vector V, achicando su dimension logica dimL 
* En el parametro exito se retornará true si la eliminacion pudo hacerse, y false en caso contrario (tipicamente, porque num no estaba en V }

procedure eliminarNumero(num : integer; var v:vector; var dimL : integer; var exito : boolean);
var
  posicion, i : integer;
begin

  posicion := pos(num,v,dimL);
  if (posicion = -1) then
    exito := false 
  else 
  begin
     for i := posicion to dimL-1 do  //hacemos los corrimientos
       v[i] := v[i+1];
     dimL := dimL - 1;  //achicamos el vector
     exito := true;
  end;
  
end;


procedure armarNodo(var aux : lista);
var
  num : integer;
begin
  num := Random(21);  // genero un numero entre 0 y 20
  
  if (num <> 20) then
  begin
    new (aux);
    aux^.num := num;
    aux^.sig := nil;
  end
  else aux := nil;
  
end;

procedure agregarAtras (var pri,ult : lista; nodo:lista);
begin
	if (pri = nil) then
	   pri := nodo
	else 
	   ult^.sig := nodo;

	ult := nodo;      
end;

procedure generarLista(var L : lista);
var
  nodo,ult : lista;
begin
	Randomize; 
	armarNodo(nodo);
	while (nodo <> nil) do 
	begin
		agregarAtras(L,ult,nodo);
		armarNodo(nodo);
	end; 
end;

procedure imprimirNodo(valor : integer);
begin
  writeln('| ',valor,' |');
end;
procedure imprimirLista(L : lista);
begin
  while (L <> nil) do
  begin
    imprimirNodo(L^.num);
    L := L^.sig;
  end;
end;


procedure probarModulos;
var
  L : lista; 
  dimL : integer;
  ok : boolean;
  v : vector;
begin
  dimL := 0;
  L := nil;
  
  cargarVector(v,dimL);  //cargo el vector
  imprimirArreglo(v,dimL);  //imprimo su contenido
  
  eliminarNumero(8,v,dimL,ok);  //intento eliminar el numero 8
  if (not ok) then
	writeln('No es pudo eliminar el 8 del vector')
  else
    writeln('Número 8 eliminado con éxito');
  
  imprimirArreglo(v,dimL);  //imprimo el vector otra vez, para corroborar que se elimino el 8
  
  generarLista(L); //armo una lista usando Random
  imprimirLista(L); //imprimo el contendido de la lista
end;


begin
  
   probarModulos;
  
  
end.
