{3. Una librería requiere el procesamiento de la información de sus productos. De cada producto
 se conoce el código del producto, código de rubro (del 1 al 8) y precio.!!!!!!!!!!!!!!!!!!!!!!
Implementar un programa modularizado que:
a. Lea los datos de los productos y los almacene ordenados por código de producto y agrupados por rubro, 
  en una estructura de datos adecuada. El ingreso de los productos finaliza cuando se lee el precio 0. !!!!!!!!!!!!
Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro:
b. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3 es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.
c. Ordene, por precio, los elementos del vector generado en b)utilizando alguno de
   los dos métodos vistos en la teoría.
d. Muestre los precios del vector ordenado.}

program ejer3;
const 
  dimF= 30;

Type
  producto = record
    codProducto: integer;
    codRubro: 1..8;
    precio: integer;
  end;

  lista = ^nodo;
  nodo = record
    dato: producto;
    sig: lista;
  end;

  v_rubro = array [1..8] of lista;

  v_rubroTres = array [1..dimF] of producto;   //HACER UN NUEVO REGISTRO QUE NO GUARDE EL DATO REDUNDANTE DEL RUBRO=3



Procedure IncializarVectorListas (VAR v: v_rubro);
Var
  i:integer;
begin
   For i:= 1 to 8 do
    v[i]:= nil;
end;



{=========================== Comienzo Inciso A ===========================}

Procedure LEER (VAR p: producto);
begin
  with p do begin
     writeln('Ingrese el precio del producto');
     readln(precio);
     If (precio <> 0) then begin
        writeln('Ingrese el codigo del producto');
        readln(codProducto);
        writeln('Ingrese el codigo de rubro del producto');
        readln(codRubro); 
     end;
  end;
end;

Procedure InsertarOrdenado (VAR L:lista; p:producto);
Var
  nuevo:lista;
  act,ant:lista;
begin
   new(nuevo);
   nuevo^.dato:= p;
   act:= L;
   ant:= L;
   While (act <> nil) AND (p.codProducto > act^.dato.codProducto) do begin
      ant:= act;
      act:= act^.sig;
   end;
   If (act = ant) then
     L:= nuevo
   Else
     ant^.sig:= nuevo;
   nuevo^.sig:= act;   
end;


//----------------------------------------------------------------------------------
Procedure CargarLista (VAR L:lista);
Var
  p:producto;
begin
  LEER (p);
  While (p.precio <> 0) do begin
    InsertarOrdenado (L,p);
    writeln;                                                                     //ESTOS DOS MODULOS PODRIAN SER SOLO UNO QUE VAYAN CARGANDO LOS DATOS
                                                                                 //EN EL VECTOR EN LA LISTA CORRESPONDIENTE
    LEER (p);
  end;
end;

Procedure CargarVectorListas (VAR v:v_rubro; L: lista);
Var
  pos:integer;
begin
  While (L <> nil) do begin
    pos:= L^.dato.codRubro;
    InsertarOrdenado (v[pos],L^.dato);
    L:= L^.sig;
  end;
end;
//-------------------------------------------------------------------------------
{=========================== Fin Inciso A ===========================}





{=========================== Comienzo Inciso B ===========================}

Procedure CargarRubroTres (VAR vtres: v_rubroTres; VAR dimL: integer; L:lista);
begin
  While (L <> nil) AND (dimL < dimF) do begin
    dimL:= dimL + 1;
    vtres[dimL]:= L^.dato;
    L:= L^.sig;
  end;
end;

{=========================== Fin Inciso B ===========================}




{=========================== Comienzo Inciso C ===========================}

Procedure Ordenacion (VAR vtres: v_rubroTres; dimL:integer);
Var
  i,j:integer;
  actual: producto;
begin
  For i:= 2 to dimL do begin
    actual:= vtres[i];
    j:= i - 1;
    While (j <> 0) and (vtres[j].precio > actual.precio) do begin
         vtres[j+1]:= vtres[j];
        j:= j - 1
    end;
    vtres[j+1]:= actual;
  end;
end;

{=========================== Fin Inciso C ===========================}




{=========================== Comienzo Inciso D ===========================}

Procedure Imprimir (vtres:v_rubroTres; dimL: integer);
Var
  i:integer;
begin
  For i:= 1 to dimL do 
    writeln('En la posicion [',i,']',' el precio es $',vtres[i].precio);
end;

{=========================== Fin Inciso D ===========================}





{=========================== PROGRAMA PRINCIPAL ===========================}

VAR
  dimL: integer;
  v:v_rubro;
  L:lista;
  vtres: v_rubroTres;
begin
   L:= nil;  //NO HACE FALTA
   dimL:= 0;
   IncializarVectorListas (v);
   {CargarLista (L);          //PODRIAN SER UN SOLO MODULO
   CargarVectorListas (v,L);}
   CargarRubroTres(vtres,dimL,v[3]);
   Ordenacion (vtres,dimL);
   Imprimir (vtres,dimL);

   // FALTO HACER: Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro.
End.
