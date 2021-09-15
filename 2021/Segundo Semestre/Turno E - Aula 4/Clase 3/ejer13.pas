{Un teatro tiene funciones los 7 días de la semana. Para cada día se tiene una lista con las
entradas vendidas. Se desea procesar la información de una semana.
Implementar un programa que:
a. Genere 7 listas con las entradas vendidas para cada día. De cada entrada se lee día (de 1
a 7), código de la obra, asiento y monto. La lectura finaliza con el código de obra igual a 0.
Las listas deben estar ordenadas por código de obra de forma ascendente.
b. Genere una nueva lista que totalice la cantidad de entradas vendidas por obra. Esta lista
debe estar ordenada por código de obra de forma ascendente.}

Program ejer13;

Type

  r_Entrada = record
     dia:1..7;
     codObra:integer;
     asiento: integer;
     monto: real;
  end;

lista = ^nodo;
nodo = record
   dato: r_Entrada;
   sig: lista;
end;


r_nuevaEntrada = record
  total: integer;
  codigo: integer;
end;

nuevaLista = ^NuevoNodo;
NuevoNodo = record
   dato: r_nuevaEntrada;
   sig:nuevaLista;
end;


v_dias = array [1..7] of lista;


Procedure InicializarVectorListas (VAR v:v_dias);
Var
  i: integer;
begin
  For i:= 1 to 7 do
    v[i]:= nil;
end;




{===================== Comienzo Inciso A =====================}

Procedure Leer (Var e:r_Entrada);
begin
  with e do begin
    writeln('Ingrese el codigo de obra:');
    codObra:= random(5);
    If (codObra <> 0) then begin
      writeln('Ingrese dia: ');
      dia:= random(7)+1;
      writeln('ingrese el asiento: ');
      asiento:= random(101);
      writeln('Ingrese el monto: ');
      monto:= random(1001);
    end;
  end;
end;



Procedure InsertarOrdenado (VAR L:lista; e:r_Entrada);   //ORDENADO POR CODIGO DE OBRA
Var
  nuevo:lista;
  act,ant: lista;
begin
  new(nuevo);
  nuevo^.dato:= e;
  act:= L;
  ant:= L;
  While (act <> nil) AND (e.codObra > act^.dato.codObra) do begin
     ant:= act;
     act:= act^.sig;
  end;
  If (act = ant) then
    L:= nuevo
  Else
    ant^.sig:= nuevo;
 nuevo^.sig:= act;
end;



Procedure CargarVectorLista (Var v:v_dias);
Var
  e:r_Entrada;
begin
  Leer (e);
  while (e.codObra <> 0) do begin
    InsertarOrdenado (v[e.dia],e);
    writeln;
    Leer (e);
  end;
end;

{===================== Fin Inciso A =====================}



Procedure Imprimir (v:v_dias);
Var
  i: integer;
begin
  For i:= 1 to 7 do begin
     writeln('-->> DIA ',i,': ');
    While (v[i] <> nil) do begin
      writeln('Codigo de obra: ',v[i]^.dato.codObra);
      v[i]:= v[i]^.sig;
    end;
    writeln('-------------------------');
  end;
end;





{===================== Comienzo Inciso B =====================}

procedure AgregarAtras (var L:nuevaLista; re:r_nuevaEntrada);
var
 act: nuevaLista;
 nue: nuevaLista;
begin
 new (nue);
 nue^.dato:= re;
 nue^.sig := nil;
 if (L <> nil) then begin
     act := L;
     while  (act^.sig <> NIL ) do
         act := act^.sig ;
     act^.sig := nue ;
    end
 else
    L:= nue;
end;



Procedure minimo (var v:v_dias ; VAR codMin:integer);
Var
 indiceMin,i:integer;
Begin
  codMin:= 9999;
  indiceMin:= -1;
  for i:= 1 to 7 do begin
     If (v[i] <> nil) AND (v[i]^.dato.codObra <= codMin) then begin
           codMin:= v[i]^.dato.codObra;
           indiceMin:= i;
       end;
  end;
  If (indiceMin <> -1) then
    v[indiceMin]:= v[indiceMin]^.sig;
End;



Procedure mergeAcumulador (v: v_dias; var LN:nuevaLista);
Var
  re:r_nuevaEntrada;
  actual,codMin,ventasTotales: integer;
Begin
  minimo (v,codMin);
  while (codMin <> 9999) do begin
     actual:= codMin;
     ventasTotales:=0;
     while (codMin <> 9999) and ( codMin = actual) do begin
        ventasTotales:= ventasTotales + 1 ;
        minimo (v,codMin);
     end;                                                 //SALE DEL WHILE CUANDO CAMBIA DE OBRA
     re.codigo:= actual;
     re.total:= ventasTotales;
     agregarAtras(LN,re);
    end;
End;


{===================== Fin Inciso B =====================}



Procedure ImprimirNuevaLista (L:NuevaLista);
Begin
  while (L <> nil) do begin
    writeln('El codigo DE OBRA ',L^.dato.codigo,' vendio ',L^.dato.total,' ventas en total');
    writeln;
    L:= L^.sig;
  end;
End;



VAR
  v:v_dias;
  LN: nuevaLista;
Begin
  LN:= nil;
  InicializarVectorListas(v);
  CargarVectorLista(v);
  Imprimir (v);
  mergeAcumulador (v,LN);
  writeln;
  writeln('------------------------------------');
  ImprimirNuevaLista (LN);
End.
