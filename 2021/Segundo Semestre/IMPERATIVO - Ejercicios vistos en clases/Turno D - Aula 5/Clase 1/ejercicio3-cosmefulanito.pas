{3. Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 8) y precio.
Implementar un programa modularizado que:
a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos
finaliza cuando se lee el precio 0.
Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
b. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3.
Considerar que puede haber más o menos de 30 productos del rubro 3. Si la cantidad de
productos del rubro 3 es mayor a 30, almacenar los primeros 30 que están en la lista e
ignore el resto.
c. Ordene, por precio, los elementos del vector generado en b) utilizando alguno de
los dos métodos vistos en la teoría.
d. Muestre los precios del vector ordenado

}
program Hello;
const
    fin=0;
    dimF = 4;// 8
    dimF2 = 7;//30
type
    rangoRubro = 1..dimF;
    rangoVec2=1..dimF2;
    producto = record
        codProd:integer;
        codRubro:rangoRubro;
        precio:real;
    end;
    lista = ^nodo;
    nodo = record
        dato:producto;
        sig:lista;
    end;
    vecRubro = array [rangoRubro] of lista; // almaceno las listas de cada rubro
    vecRubro3 = array [rangoVec2] of producto;  // HACER UN NUEVO REGISTRO ASI NO GUARDA EL DATO REDUNDANTE DE RUBRO=3
//------------------------------------------------------
//-------------------------------------------------------
procedure leerProducto(var prod:producto);
begin
    writeln('PRECIO: $');
    readln(prod.precio);
    if (prod.precio <> fin) then begin
        writeln('CODIGO PRODUCTO:');
        readln(prod.codProd);
        writeln('CODIGO RUBRO:');
        readln(prod.codRubro);
    end;
end;
//-------------------------------------------------------
procedure insertarOrdenado(var L:lista; prod:producto);
var
  nue,  act, ant: lista; {punteros auxiliares para recorrido}
begin
  new (nue);
  nue^.dato := prod;
  act := L; {ubico act y ant al inicio de la lista}
  ant := L;
  while( act <> nil)and(prod.codProd > act^.dato.codProd)do
  begin
    ant := act;
    act:= act^.sig;
  end;
  if (act = ant) then {al inicio o lista vacía}
    L:= nue
  else {al medio o al final}
    ant^.sig:= nue;
  nue^.sig:= act;
end;
//------------------------------------
procedure inicializarVector(var vec: vecRubro);
    var
        i: integer;
    begin
        for i := 1 to dimF do
            vec[i] := nil; //tengo que inicializar en nil porque es un vector de listas
    end;
//------------------------------------------------------
procedure cargarVectorListas(var vr:vecRubro);
begin
   leerProducto(prod);
   while (prod.precio <> fin) do begin
        insertarOrdenado(vr[prod.codRubro],prod);
        leerProducto(prod);
   end; 
end;


//------------------------------------
procedure imprimirVecRubro(vr:vecRubro);
var i:rangoRubro;
begin
    for i:=1 to dimF do begin
        writeln('RUBRO:',i);
        while (vr[i]<>nil) do begin                           //MODULARIZAR EL RECORRIDO DE LA LISTA
            writeln('Cod. del producto:',vr[i]^.dato.codProd,' ');
            vr[i]:=vr[i]^.sig;
        end;
    end;
end;
//------------------------------------
procedure cargarvecRubro3 (var vec30: vecRubro3; var dimL: integer; l: lista); // l viene de vR: vecRubros, especificamente vR[3] {uso dimL como parametro para no tener q inicializar el vector por el caso de q hayan menos de 30 productos}
begin
    dimL := 0;
    while (l <> nil) and (dimL < dimF2) do begin
        dimL := dimL + 1;
        vec30[dimL].codP:= l^.dato.codP;
        vec30[dimL].precio := l^.dato.precio;
        l := l^.sig;
    end;
end;
//------------------------------------
procedure OrdenarXSeleccion ( var v: vecRubro3; dimL: integer);
var
  i, j, p:rangoVec2;
  item: producto;
begin
  for i:=1 to dimL-1 do begin {busca el mínimo v[p] entre v[i] , ..., v[N] }
    p := i;
    for j := i+1 to dimL do
      if v[ j ].precio < v[ p ].precio then     //accedo al campo del registro por el cual se desea ordenar el vector
        p:=j;
    {intercambia v[i] y v[p] }
    item := v[ p ];
    v[ p ] := v[ i ];
    v[ i ] := item;
  end;
end;
//------------------------------------

procedure OrdenarXInsercion(var v: vecRubro3; dimL: integer);
var 
    i, j:rangoVec2;
    actual: producto;
begin

    for i:= 2 to dimL do begin
           actual:=v[i];
           j:= i-1;
           while (j > 0) and (v[j].precio > actual.precio) do begin
                 v[j+1]:=v[j];
                 j := j-1;
             end;
        v[j+1] := actual;
    end;
end;
//-----------------------------------
procedure imprimirPreciosOrdenados(vec30:vecRubro3);
var i:rangoRubro;
begin
    for i:=1 to dimF do begin
        writeln('----------------------------------');
        writeln('| $ ',vec30[i].precio:4:2);
        write('|');
        writeln('----------------------------------');
    end;
end;
//-----------------------------------
var
    vecR:vecRubro;
    l:lista;
    vec30:vecRubro3;
    dimL:integer;
    num:integer;
begin
    inicializarVector(vecR);
    
    cargarVectorListas(vecR,l);
    imprimirVecRubro(vecR);
    cargarvecRubro3(vec30,dimL,vecR[3]);
    writeln('Ingrese 1 para SELECCION o 2 para INSERCION:' );
    readln(num);
    case num of
    1: OrdenarXSeleccion(vec30,dimL);
    2: OrdenarXInsercion(vec30,dimL);
    end;
    imprimirPreciosOrdenados(vec30);
end.
