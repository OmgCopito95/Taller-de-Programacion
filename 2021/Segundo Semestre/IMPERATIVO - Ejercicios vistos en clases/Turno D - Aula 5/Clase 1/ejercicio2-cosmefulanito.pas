{2. Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2021. De cada película se conoce: código de película, código de género (1:
acción, 2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror)
y puntaje promedio otorgado por las críticas.
Implementar un programa modularizado que:
a. Lea los datos de películas y los almacene por orden de llegada y agrupados por
código de género, en una estructura de datos adecuada. La lectura finaliza cuando se lee
el código de la película -1.
b. Una vez almacenada la información, genere un vector que guarde, para cada
género, el código de película con mayor puntaje obtenido entre todas las críticas.
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de
los dos métodos vistos en la teoría.
d. Luego de ordenar el vector, muestre el código de película con mayor puntaje y el
código de película con menor puntaje.}
program Hello;
const
    dimF=8;
    fin = -1;
type
    rangoGenero=1..dimF;
    pelicula = record
        codPeli:integer;
        codGenero:rangoGenero;
        puntajProm:real;
    end;
    
    lista = ^nodo;
    nodo = record
        dato:pelicula;
        sig:lista;
    end;
    
    mejorPeli=record
        codPeli:integer;
        puntajProm:real;
    end;
    
    vec_genero = array [rangoGenero] of lista;
    
    vec_codigos = array [rangoGenero] of mejorPeli; 
//------------------------------------
procedure leerPelicula (var peli:pelicula);
begin
    writeln('CODIGO:');
    readln(peli.codPeli);
    if (peli.codPeli <> fin) then begin
        writeln('GENERO');
        readln(peli.codGenero);
        writeln('PUNTAJE PROMEDIO');
        readln(peli.puntajProm);
    end;
end;
//------------------------------------
procedure inicializarVector(var vec: vec_genero);
    var
        i: integer;
    begin
        for i := 1 to dimF do
            vec[i] := nil; //tengo que inicializar en nil porque es un vector de listas
    end;
//------------------------------------
procedure agregarAtras(var l: lista; peli:pelicula);  //recorre toda la lista
var                    //si yo usaba con puntero al ultimo necesitaba 8 punteros a ult
    nue, act, ant: lista;
begin
    new(nue);
    nue^.dato := peli;
    ant := l;
    act := l;
    while (act <> nil) do begin
        ant := act;
        act := act^.sig;
    end;
    if (ant = act) then
        l := nue
    else
        ant^.sig := nue;
    nue^.sig := act;
end;
//------------------------------------
procedure cargarLista (var vec:vec_genero);
var
    peli:pelicula;
begin
    leerPelicula(peli);
    while (peli.codPeli <> fin) do begin
        agregarAtras(vec[p.codGenero], peli); // MANDA LA LISTA DE LA POS DEL VECTOR, Y EL REGISTRO A GUARDAR
        leerPelicula(peli);
    end;
end;
//------------------------------------
procedure imprimirArreglo(vec:vec_genero);
var
    i:rangoGenero;
begin
   for i:=1 to dimF do begin
		imprimirLista(vec[i]);   // HACER UN MODULO QUE RECORRA LA LISTA DEL VECTOR E IMPRIMA
        {writeln('COD PELI: ',vec[i]^.dato.codPeli);
        writeln ('COD GEN: ',vec[i]^.dato.codGenero);
        writeln('PROMEDIO: ',vec[i]^.dato.puntajProm:1:2);}       // ESTO ESTA MAL PORQUE NO SE ESTÁ RECORRIENDO BIEN LA LISTA
    end;
end;
//------------------------------------
procedure inicializarVectorCodigos(var v2:vec_codigos);
var
    i:rangoGenero;
begin
    for i:=1 to dimF do
        v2[i].codPeli:=0;
end;
//-------------------------------
procedure mayorPuntaje(l:lista; var codMax:integer;var maxPuntaje:real);
begin
    maxPuntaje:=-1;
    while (l<>nil) do begin
        if(l^.dato.puntajProm >maxPuntaje) then begin
            maxPuntaje:=l^.dato.puntajProm;    //PODRIA USAR UN REGISTRO MAXIMO PARA NO ESTAR USANDO DOS VARIABLES
            codMax:=l^.dato.codPeli;
        end;
        l:=l^.sig;
    end;
end;
//---------------------------------
procedure  cargarMejorPeli(var info:mejorPeli;puntajMax:real;codigoMax:integer);
begin
    info.puntajProm:=puntajMax;
    info.codPeli:=codigoMax;
end;
//--------------------------------
procedure cargarVectorCodigos(v:vec_genero; var v2:vec_codigos; codMax: integer);
var
    i:rangoGenero;
    maxPuntaje:real;
begin
    for i := 1 to dimF do begin
        codMax:=-1; //porque tengo que tener inicializado para cada posición
        mayorPuntaje(v[i],codMax,maxPuntaje);
        cargarMejorPeli(v2[i],maxPuntaje,codmax);
    end;
end;
//----------------------------------
procedure ordenarVecCodigos(var vec: vec_codigos);
var
    i, j: rangoGenero;
    actual:mejorPeli;
begin

    for i:=2 to dimF do begin
        actual:= vec[i];
        j:= i-1;
        while (j > 0) and (vec[j].puntajProm > actual.puntajProm) do begin //ordena de MENOR A MAYOR
            vec[j+1] := vec[j];
            j:=j-1;
        end;
        vec[j+1] := actual;
    end;
end;
//------------------------------------
procedure imprimirV2(v2:vec_codigos);
var i:rangoGenero;
begin
    writeln('------------------------');
    for i:=1 to dimF do
    writeln('|',v2[i].puntajProm,' ',v2[i].codPeli);
    writeln('|');
end;
//------------------------------------
procedure imprimirPuntajesExtremos(codigoMin,codigoMax:integer);
begin
   writeln(codigoMax,' código de película con mayor puntaje');
    writeln(codigoMin,' código de película con menor puntaje');
end;
//------------------------------------
var
    l:lista;
    v:vec_genero;
    dimL:integer;
    v2:vec_codigos;
    codMax:integer;
begin
    inicializarVector(v);
    cargarLista(l,v);
    imprimirArreglo(v);
    inicializarVectorCodigos(v2);
    cargarVectorCodigos(v,v2,codMax); 
    imprimirV2(v2);
    ordenarVecCodigos(v2);
    imprimirPuntajesExtremos(v2[1].codPeli,v2[dimF].codPeli);  //TENER EN CUENTO QUE ESTO FUNCIONARIA SI HAY PELICULAS DE TODOS LOS CODIGOS DE PELICULAS
                                                               // LLEVAR CONTROL DE LA DIML EN VEZ DE LA DIMF
end.
