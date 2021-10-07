program puntodos;
const
dimf=8;

type
rango=1..8;

pelis=record
  cod:integer;
  cod_genero:rango;
  pun_promedio:real;
end;

lista=^nodo;

nodo=record
  elem:pelis;
  sig:lista;
end;

vector_reales=array[rango]of real;  //DEBERIA GUARDAR CODIGO Y PUNTAJE

vector=array[rango]of lista;

//FALTO INICIALIZAR EL VECTOR DE LISTAS EN NIL

//procesos
procedure inicializar_vector_reales(var vec_reales: vector_reales);
var
i:integer;
begin
  for i := 1 to dimf do begin
    vec_reales[i]:=0;        //AHORA VA A SER UN REGISTRO
  end;
end;  

procedure agregar_atras(var l:lista; p:pelis);
var
nue:lista;
ant:lista;
act:lista;
begin
   new(nue);
   nue^.elem:=p;
   nue^.sig:=nil;
   ant:=l;
   act:=l;
   while (act<>nil) do begin
     ant:=act;
     act:= act^.sig
   end;
   if(ant=act)then begin
     l:=nue;
   end
    else begin
      ant^.sig:=nue;
    end;
    nue^.sig:=act;
end;


procedure leer_pelis(var p:pelis);
begin
  writeln('ingrese codigo de pelicula: ');
  readln(p.cod);
  if(p.cod <>-1)then begin
    writeln('ingrese genero de pelicula: ');
    readln(p.cod_genero);
    writeln('ingrese puntaje promedio: ');
    readln(p.pun_promedio);
  end;
end;


procedure cargar_info(var l:lista;var v:vector);
var
p:pelis;
begin
  leer_pelis(p);
  while(p.cod<>-1)do begin
    agregar_atras(v[p.cod_genero],p); // se pasa la lista ya con la posicion y los datos de la peli.
    leer_pelis(p);
  end;
end;


procedure buscar_promedios_maximos(v:vector; var v_r: vector_reales);
var
i:integer;
max:real;
begin

  for i:=1 to dimf do begin
    max:=-1;

    while(v[i]<>nil)do begin		//MODULARIZAR recorrerLista(v[i])
      if(v[i]^.elem.pun_promedio > max)then begin
        max:= v[i]^.elem.pun_promedio;
        v[i]:=v[i]^.sig;  // como moverme en los nodos ?
      end;
    end;
    v_r[i]:=max;
  end;  
end;

procedure ordenar_vector_promedios(var v :vector_reales);
var
 i:integer;
 j:integer;
 actual:real; //registro nuevo
 begin
   for i := 2 to dimf do begin 
     actual:=v[i];  
     j:=i-1;     
     while (j>0) and (v[j].puntaje > actual.puntaje) do begin    
       v[j+1]:=v[j];
       j:=j-1;
     end;
     v[j+1]:=actual;
   end;              
 end;

procedure imprimir(v:vector);
begin
  writeln('----------------');
  writeln('codigo de pelicula con menor promedio: ',v[1].cod);
  writeln('codigo de pelicula con mayor promedio: ',v[dimf].cod);    //TENER EN CUENTA QUE PODRIA NO HABER PELICULAS DE TODOS LOS GENEROS
  writeln('----------------');
end;

//programa principal
var
  l:lista;
  v:vector;
  v_r:vector_reales;
begin
   l :=nil;
   inicializar_vector_reales(v_r);
   cargar_info(l,v);
   buscar_promedios_maximos(v,v_r);
   ordenar_vector_promedios(v_r);
   imprimir(v);
end.
