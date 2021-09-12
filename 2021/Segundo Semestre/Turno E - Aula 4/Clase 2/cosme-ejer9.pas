{Implemente un programa que invoque a un módulo que genere un árbol binario de
búsqueda con nombres de personas que se leen desde teclado. La lectura finaliza con el
nombre ‘ZZZ’ que no debe procesarse. También debe invocar a otro módulo que reciba el
árbol generado y un nombre, y retorne verdadero si existe dicho nombre en el árbol o falso
en caso contrario.}

Program ejer9;
Type
  str20 = string [20];
  arbol = ^nodo;
  nodo = record
    dato: str20;
    Hd: arbol;
    Hi:arbol;
  end;





{========================= Comienzo Cargar Arbol =========================}

Procedure Crear (VAR a:arbol; nom:str20);
begin
  If (a = nil) then begin
    new(a);
    a^.dato:= nom;
    a^.Hd:= nil;
    a^.Hi:= nil;    
  end
  Else
     If (nom < a^.dato) then
       Crear(a^.Hi,nom)
     Else
       Crear(a^.Hd,nom);
end;


Procedure CargarArbol (VAR a:arbol);
Var
  nom:str20;
begin
  writeln('Ingrese un nombre');
  readln(nom);
  While (nom <> 'ZZZ') do begin
    Crear(a,nom);
    writeln;
    writeln('Ingrese un nombre');
    readln(nom);
  end;
end;

{========================= Fin Cargar Arbol =========================}





{========================= Comienzo Buscar Nombre =========================}

Function Buscar (a:arbol; name:str20): boolean;            
begin
    If (a = nil) then
      Buscar:= false
    Else
      If (name =a^.dato) then
        Buscar:= true
        Else
          If (name < a^.dato) then
            Buscar:= Buscar (a^.Hi,name)
            else
              Buscar:= Buscar (a^.Hd,name);
end;

{========================= Fin Buscar Nombre =========================}




VAR
  a:arbol;
  name:str20;
begin
  a:= nil;
  CargarArbol (a);
  write('ingrese un nombre a buscar :');
  readln(name);
  If (Buscar (a,name)) then
    writeln('El nombre ',name,' existe')
  Else
    writeln('El nombre ',name,' NO existe');
End.