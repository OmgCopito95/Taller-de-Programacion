program Clase1;
const
  CANTMAX=20;
type
  rangovector = 1..CANTMAX;
  participante = record
		codigo,edad : integer;
	end;
  vector = array[rangovector] of participante;
  
  lista = ^nodo;
  nodo = record
			dato : participante;
			sig : lista;
		end;
  
procedure leerParticipante(var x : participante);
begin
   writeln('Ingrese el código del participante');
   readln(x.codigo);
   if (x.codigo <> -1) then
   begin
     writeln('Ingrese la edad del participante');
     readln(x.edad);  
	end 
	else
    	writeln('Ingresó el -1 | Fin de la lectura de participantes');
end;  

{ carga el vector hasta que se lee el número 0 o se hayan leído 20 números }
procedure cargarVector(var v : vector; var i : integer);
var
  p : participante;
begin
   writeln('Inicia la carga del vector. Le ingresan participantes hasta que se lee el codiog -1 o hasta un máximo de 20 participantes');
   leerParticipante(p);
   while (p.codigo <> -1) and (i < CANTMAX) do begin
      i := i + 1;
      v[i] := p;
      leerParticipante(p);
   end;
end;

procedure imprimirElemento(pos : rangoVector; valor:participante);
begin
  writeln('V[ ',pos,' ] => Codigo ',valor.codigo,' - Edad: ',valor.edad);
end;

{ imprime el contenido del arreglo }
procedure imprimirArreglo(v : vector; dimL : rangovector);
var
  i : rangovector;
begin
  for i:=1 to dimL do 
	imprimirElemento(i,v[i]);

   writeln('**************************************');	
end;

function comparar(p1,p2 : participante) : boolean;
var
  result : boolean;
begin
   comparar := (p1.edad > p2.edad);
{   if (p1.edad > p2.edad) then
      result := true
    else result := false;
   comparar := result; }
     
end;
procedure ordenar(var v : vector; dimL : rangovector);
var
  i,j : integer;
  actual : participante;
begin

  for i:= 2 to dimL do begin
    actual := v[i];
    j := i-1;
    while (j >0) and (comparar(v[j], actual)) do
    begin
		v[j+1]:= v[j];
		j:= j - 1;
    end;
    v[j+1]:= actual;
  end;

end;


{ Elimina del vector a todos los participantes entre 20 y 22 años }

procedure eliminarParticipantes(var v:vector; var dimL : integer);
var
  posicion, i, cant : integer;
begin
  
  cant := 0;
  i := 1;
  
  {busco al primer participante de 20 años o mas}
  while (i <= dimL) and (v[i].edad < 20) do 
	i := i +1;
  
  posicion:= i;
  while (i <= dimL) and (v[i].edad <=22) do
	i := i + 1;

  { vamos a eliminar a todos los parcipantes entre las posiciones posicion e i del vector V }	  
  cant := i - posicion;
  for i := (posicion+cant) to dimL do
     v[i-cant] := v[i];
	  
  dimL := dimL - cant;
	  
end;

procedure agregarAtras(var L,ult : lista; p:participante);
var 
  aux : lista;
begin
  new(aux); 
  aux^.dato := p;
  aux^.sig := nil;
  
  if (L = NIL) then
	L := aux
  else
    ult^.sig := aux;
  ult := aux;
end;


procedure generarLista(var L : lista; V : vector; dimL : integer);
var
  ult : lista;
  i : integer;
begin
  L := nil;
  for i:=1 to dimL do
     agregarAtras(L, ult,v[i]);
end;  

procedure imprimirLista(L : lista);
begin
  while (L <> NIL) do 
  begin
	  writeln('Codigo: ',L^.dato.codigo,' - Edad: ',L^.dato.edad);
	  L := L^.sig;
  end;
end;

procedure probarModulos;
var
  dimL : integer;
  v : vector;
  L : lista;
begin
  dimL := 0;

  cargarVector(v,dimL);  //cargo el vector
  writeln('Vector de participantes luego de completar la lectura de datos');
  imprimirArreglo(v,dimL);  //imprimo su contenido
  
  ordenar(v,dimL);
  writeln('Vector de participantes luego de ordenarlo por edad');
  imprimirArreglo(v,dimL);
  
  eliminarParticipantes(v,diml);
  writeln('Vector de participantes luego de eliminar a los que tienen entre 20 y 22 años');
  imprimirArreglo(v,dimL);  //imprimo el vector otra vez, para corroborar que se elimino el 8
  
  writeln('Ahora vamos a pasar a todos los participantes a una lista');
  generarLista(L,V,dimL);
  writeln('Lista de participantes resultante del vector previo ');
  imprimirLista(L);
end;


begin
  
   probarModulos;
  
  
end.
