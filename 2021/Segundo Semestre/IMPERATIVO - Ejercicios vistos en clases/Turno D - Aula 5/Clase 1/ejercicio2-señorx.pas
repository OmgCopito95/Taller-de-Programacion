program dos;
const
    dimF = 8;
type
    rango = 1..dimF;
    pelicula = record
        cod_Peli:integer;
        cod_genero:rango;
        punt_prom:real;
    end;
    lista = ^nodo;
    nodo = record
        dato:pelicula;
        sig:lista;
    end;
    vector = array [rango] of lista;
    
    peli_puntaje = record
        puntaje:real;
        codigo:Integer;
    end;
    vector_puntaje = array [rango] of peli_puntaje;


    // FALTA INICIALIZAR EN NIL EL VECTOR DE LISTAS DE PELICULAS
//_________________________________________________________________
procedure AgregarAlFinal1(var pri:lista;per:pelicula); 
var  
   act, nue : lista;
begin 
   new (nue);
   nue^.dato:= per;
   nue^.sig := NIL;
   if pri <> Nil then 
   begin
       act := pri ;
       while  (act^.sig <> NIL ) do 
           act := act^.sig ;
       act^.sig := nue ;
   end
   else
       pri:= nue;
end;
//_________________________________________________________________
procedure leerPeli(var p:pelicula);
begin
    writeln('Codigo de Pelicula: '); ReadLn(p.cod_Peli);
    if (p.cod_Peli <> -1) then
    begin
        writeln('Codigo de Genero: '); ReadLn(p.cod_genero);
        writeln('Puntaje Promedio: '); ReadLn(p.punt_prom);
    end;
end;
//_________________________________________________________________
procedure CargarPelis(var v:vector);
var
    p:pelicula;
begin
    leerPeli(p);
    while (p.cod_Peli <> -1) do
    begin
        AgregarAlFinal1(v[p.cod_genero],p);
        leerPeli(p);
    end;
end;
//_________________________________________________________________
procedure imprimirVector(v:vector);
var
    i:integer;
begin
    for i:=1 to dimF do
    begin
        while v[i] <> nil do
        begin
            writeln('Codigo Peli: ',v[i]^.dato.cod_Peli);
            writeln('Codigo Genero: ',v[i]^.dato.cod_genero);
            writeln('Puntaje Promedio: ',v[i]^.dato.punt_prom:2:2);
            v[i]:=v[i]^.sig;
        end;
    end;
end;
//_________________________________________________________________
procedure inicializarPuntajes(var vp:vector_puntaje);
var
    i:integer;
begin
    for i:=1 to dimF do
    begin
        vp[i].puntaje:=-1;
        vp[i].codigo:=-1;
    end;
end;
//_________________________________________________________________
procedure MayorPuntaje(v:vector; var vp:vector_puntaje);
var
    i:integer;
begin
    for i:=1 to dimF do
    begin
    while v[i] <> nil do
        begin
            if (v[i]^.dato.punt_prom>vp[i].puntaje) then
            begin
                vp[i].puntaje:=v[i]^.dato.punt_prom;       //CONVIENE UTILIZAR UN REGISTRO MAXIMO PARA NO ACCEDER TANTAS VECES AL VECTOR
                vp[i].codigo:=i;
            end;
            v[i]:=v[i]^.sig;
        end;
    end;
    
end;
//_________________________________________________________________

Procedure OrdenarVector ( var v: vector_puntaje );
var 
    i, j, p: Integer;
    item:peli_puntaje;
begin
    for i:=1 to dimF-1 do 
    begin {busca el mínimo y guarda en p la posición}
        p := i;
        for j := i+1 to dimF do
            if v[ j ].puntaje < v[ p ].puntaje then p:=j;
        {intercambia v[i] y v[p]}
        item := v[ p ];   
        v[ p ] := v[ i ];   
        v[ i ] := item;
    end;
end;
//_________________________________________________________________
procedure imprimirVector2(v:vector_puntaje);
var
    i:integer;
begin
    for i:=1 to dimF do
    begin
        writeln('Puntaje: ',(v[i].puntaje):2:2);
        writeln('Codigo: ',v[i].codigo);
    end;
end;
//_________________________________________________________________
var
    v:vector;
    vp:vector_puntaje;
begin
    inicializarPuntajes(vp);
    CargarPelis(v);//A
    WriteLn('____________');
    imprimirVector(v);
    MayorPuntaje(v,vp);//B
    OrdenarVector(vp);
    WriteLn('____________');
    imprimirVector2(vp);
    WriteLn('____________');
    WriteLn('El codigo de la pelicula con menor puntaje es: ', vp[1].codigo);
    WriteLn('El codigo de la pelicula con menor puntaje es: ', vp[8].codigo);   //TENER EN CUENTA QUE NO SIEMPRE PUEDE HABER PELICULAS DE TODOS LOS GENEROS
end.
