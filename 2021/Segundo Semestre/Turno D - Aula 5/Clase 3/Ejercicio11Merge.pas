{11. Un cine posee la lista de pel�culas que proyectar� durante el mes de octubre. De cada
pel�cula se conoce: c�digo de pel�cula, c�digo de g�nero (1: acci�n, 2: aventura, 3: drama,
4: suspenso, 5: comedia, 6: b�lica, 7: documental y 8: terror) y puntaje promedio otorgado
por las cr�ticas.
Implementar un programa que contenga:
a. Un m�dulo que lea los datos de pel�culas y los almacene ordenados por c�digo de
pel�cula y agrupados por c�digo de g�nero, en una estructura de datos adecuada. La
lectura finaliza cuando se lee el c�digo de pel�cula -1.
b. Un m�dulo que reciba la estructura generada en el punto a y retorne una
estructura de datos donde est�n todas las pel�culas almacenadas ordenadas por c�digo de
pel�cula.}
program Hello;
const
    dimF = 8;
    FIN = -1;
type
    rangoGen = 1..dimF;
    pelicula = record
        codPeli:integer;
        codGenero:rangoGen;
        puntajeProm:real;
    end;
    
    lista =^nodo;
    nodo = record
        dato:pelicula;
        sig:lista;
    end; 
    vecGenero = array [rangoGen] of lista;


//----------Fin del type ----------
//----------Leer pelicula-----------------
procedure leerPelicula (var peli:pelicula);
begin
    writeln('CODIGO DE PELICULA: ');
     peli.codPeli:= random (50)-1;//readln(peli.codPeli);
     writeln(peli.codPeli);
    if (peli.codPeli <> FIN) then begin
        writeln('GENERO');
        peli.codGenero := random (8)+1;//readln(peli.codGenero);
        writeln(peli.codGenero);
        writeln('PUNTAJE PROMEDIO');
        peli.puntajeProm := random (11);//readln(peli.puntajeProm);
        writeln(peli.puntajeProm:2:2);
    end;
end;
//--------Insertar ordenado-------------
procedure insertarOrdenado(var L : lista; dato : pelicula);
var
	aux,ant,act : lista;
	
begin
	new(aux); 
	aux^.dato := dato;
	act := L; {ubico act al inicio de la lista}
	ant := act;
	while (act <> nil) and (act^.dato.codPeli < dato.codPeli) do begin
		ant := act;
		act := act^.sig; {avanzo en la lista}
	end;
	if (ant=act) then begin //primero de la lista, o lista vac�a
		aux^.sig := L;
		L := aux;
	end 
	else begin {el nuevo nodo va en el medio o al final de la lista}
		ant^.sig := aux; { actualizo puntero para insertar nuevo nodo }
		aux^.sig := act; { inserto nuevo nodo }
	end;
end;
//------------Cargar lista------------------------
procedure cargarListaEnVec ( var vec:vecGenero);
var
    i:integer;
    peli:pelicula;
begin
    for i := 1 to dimF do
        vec[i]:=nil; //inicializo las listas
    leerPelicula(peli);
    while (peli.codPeli <> fin) do begin
        insertarOrdenado(vec[peli.codGenero], peli);
        leerPelicula(peli);
    end;
end;
//---------Agregar atras-----------
procedure agregarAtras(var l,ult: lista; peli:pelicula);
var
    nue:lista;
begin
	new(nue);
	nue^.dato := peli;
	nue^.sig := nil;
	if (l = nil) then
		l := nue
	else
		ult^.sig := nue;
	ult := nue;	
end;
//-----------Minimo----------------
procedure minimo (var vg:vecGenero; var min:pelicula);
var
    pos,i:integer;
begin
  min.codPeli:=999;

  pos:= -1;
  for i:= 1 to dimF do
     if (vg[i] <> nil) and (vg[i]^.dato.codPeli <= min.codPeli) then begin
            pos:= i; //me guardo la posicion de la lista
            min.codPeli:= vg[i]^.dato.codPeli;  //actualizo el minimo
     end;
  if (pos <> -1) then begin// si encontre un minimo, avanzo en el estante
      min.puntajeProm:= vg[pos]^.dato.puntajeProm;  //actualizo los campos que me faltaban
      min.codGenero:=vg[pos]^.dato.codGenero;
      vg[pos]:= vg[pos]^.sig;
  end;
end;
//------------ Merge -------------
Procedure merge (vg:vecGenero; var nuevo:lista);
var
    ult:lista;
    min:pelicula;
Begin
    nuevo:= nil;
    minimo (vg,min); //cuando sale min tiene la pelicula con cod pelicula mas chiquito
    while (min.codPeli <> 999) do begin  //si no entra al while termine de hacer el merge (es el mismo valor del minimo)
        agregarAtras(nuevo,ult,min); // se agregan en orden por codigo de pelicula
        minimo (vg,min);
    end;
end;  

//-------------Imprimir Lista-----------------------
procedure imprimirLista(l:lista);
begin
    while (l<>nil) do begin
        writeln('COD PELI: ',l^.dato.codPeli); 
        writeln ('COD GEN: ',l^.dato.codGenero);
        writeln('PROMEDIO: ',l^.dato.puntajeProm:1:2);
        l:=l^.sig;
    end;
end;
//-------------Imprimir arreglo-----------------------
procedure imprimirArreglo(vec:vecGenero);
var
    i:rangoGen;
begin
   for i:=1 to dimF do begin
        writeln('Para el genero: ',i);
        imprimirLista(vec[i]);
    end;

end;

//----------Programa principal ----------
var 
    vg:vecGenero;
    l:lista;
    ln:lista;
begin
    randomize;
    cargarListaEnVec(vg);
    imprimirArreglo(vg);
    merge(vg,ln);
    imprimirListaNueva(ln); //implementar
end.
