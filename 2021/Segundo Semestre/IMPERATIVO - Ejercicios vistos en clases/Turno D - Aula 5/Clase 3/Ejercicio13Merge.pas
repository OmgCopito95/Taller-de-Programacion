{13. Un teatro tiene funciones los 7 días de la semana. Para cada día se tiene una lista con las
entradas vendidas. Se desea procesar la información de una semana.
Implementar un programa que:
a. Genere 7 listas con las entradas vendidas para cada día. De cada entrada se lee día (de 1
a 7), código de la obra, asiento y monto. La lectura finaliza con el código de obra igual a 0.
Las listas deben estar ordenadas por código de obra de forma ascendente.
b. Genere una nueva lista que totalice la cantidad de entradas vendidas por obra. Esta lista
debe estar ordenada por código de obra de forma ascendente.}
program Hello;
const
    dimF = 7;
    FIN = 0;
type
    rangoDia = 1..dimF;

    entrada = record
        dia: rangoDia;
        codObra:integer;
        asiento:integer;
        monto:real;
    end;
    
    lista =^nodo;
    nodo = record
        dato:entrada;
        sig:lista;
    end; 
    vecDias = array [rangoDia] of lista;
    
    infoTotal= record //hago otro registro porque solo me interesa el codigo y el total
        codObra:integer;
        cantVendidas:integer;
    end;
    
    listaTotalE = ^nodo2;
    
    nodo2 = record
        dato:infoTotal;
        sig:listaTotalE;
    end;

//----------Fin del type ----------

//----------Leer entrada-----------------
procedure leerEntrada (var ent:entrada);
begin
    ent.codObra := random (51);
    writeln ('Codigo de obra: ',ent.codObra);
    if (ent.codObra <> FIN) then begin
        ent.dia := random (7)+1;
        writeln ('Dia: ',ent.dia);
        ent.asiento := random (50);
        writeln ('Asiento: ',ent.asiento);
        ent.monto := random (300);
        writeln ('Codigo de producto: ',ent.monto:2:2);
    end;
end;
//---------Inicializar Vec de listas----------------
procedure inicializarVector(var vec: vecDias);
var
    i: integer;
begin
    for i := 1 to dimF do
        vec[i] := nil; //tengo que inicializar en nil porque es un vector de listas
end;
//--------Insertar ordenado-------------

procedure insertarOrdenado (var pri: lista; dato: entrada);
var
    aux, ant, act: lista;
begin
    new(aux);   
    aux^.dato := dato;
    act := pri; {ubico act al inicio de la lista}
    while (act <> nil) AND (act^.dato.codObra < dato.codObra) do begin
            ant := act;
            act := act^.sig; {avanzo en la lista}
    end;
    if (act = pri) then {si está vacía}
            pri := aux
    else {el nuevo nodo va en el medio o al final de la lista}
            ant^.sig := aux; { actualizo puntero para insertar nuevo nodo }
    aux^.sig := act; { inserto nuevo nodo }
end;

//------------Cargar lista------------------------
procedure cargarListaEnVec ( var vec:vecDias);
var
    ent:entrada;
    i:rangoDia;
begin
    leerEntrada(ent);
    while (ent.codObra <> FIN) do begin
          insertarOrdenado(vec[ent.dia], ent);
          leerEntrada(ent);
    end;
end;
//---------Agregar atras-----------
procedure agregarAtras(var l, ult:listaTotalE; info:infoTotal);
var
    nue:listaTotalE;
begin
	new(nue);
	nue^.dato := info;
	nue^.sig := nil;
	if (l = nil) then
		l := nue
	else
		ult^.sig := nue;
	ult := nue;	
end;
//-----------Minimo----------------
procedure minimo (var vec:vecDias; var min:entrada); //mandar un integer
var
    pos,i:integer;
begin
  min.codObra:=999;
  pos:= -1;
  for i:= 1 to dimF do
     if (vec[i] <> nil) and (vec[i]^.dato.codObra <= min.codObra) then begin
            pos:= i; {guarda la posicion de la lista}  
            min.codObra:= vec[i]^.dato.codObra;{actualiza min}
        end; 
  if (pos <> -1) then {si encontre un minimo, avanzo}
      vec[pos]:= vec[pos]^.sig;
end;
//------------ Merge -------------
Procedure merge (vec:vecDias; var nuevo:listaTotalE);
var
    min:entrada; //INTEGER
    info:infoTotal; //acá voy a ir almacenando la informacion del codigo y total de venta
    ult: listaTotalE;
    codActual: integer;
begin
     nuevo:= nil;
     minimo (vec, min); // se devuelve el primer minimo  //MIN ES ENTERO
      while (min.codObra <> 999) do begin //mientras que el minimo no sea el corte
         codActual:= min.codObra; //asigno el nuevo actual  //USAR REGISTRO INFO
         info.cantVendidas:=0; // inicializo el total de ventas para el cod actual
         while ((min.codObra <> 999) and (min.codObra = codActual)) do begin // mientras siga viniendo el mismo codigo, sumo 1
            info.cantVendidas:= info.cantVendidas + 1;
            minimo (vec, min);
         end; //cambio de codigo
         info.codObra := codActual; // cargo el otro campo del registro acumulador  //NO SE NECESITA
         agregarAtras(nuevo,ult,info); // agrego el nuevo registro CARGADO a la lista (merge acumulador)
        end;
End;  
//---------imprimirListaMerge------
procedure imprimirMerge(l:listaTotalE);
begin
    writeln('___________________');
    while (l<>nil) do begin
        writeln('COD OBRA: ',l^.dato.codObra); 
        writeln('TOTAL DE VENTAS: ',l^.dato.cantVendidas);
        l:=l^.sig;
    end;
end;
//----------Programa principal ----------
var
    v:vecDias;
    ltotal:listaTotalE;
begin
    randomize;
    inicializarVector(v);
    cargarListaEnVec(v);
    merge(v,ltotal);
    imprimirMerge(ltotal);
end.
