  
program actividad1;

Type
 cliente = record
  apeynom:string;
  dni:integer;
  categoria:integer;
 end;
 lista = ^nodo;
 nodo = record
  dato:cliente;
  sig:lista;
 end; 
 arbol= ^nodoA;
 nodoA= record
  dato: cliente;
  HI:arbol:
  HD:arbol;
 end;
procedure leerCliente (var cli:cliente);
begin
 readln(cli.apeynom);
 readln(cli.dni);
 readln(cli.categoria);
end;    

procedure cargarLista (L:lista);
var
 cliente:cliente;
 aux:nodo;
begin
 leer (cliente);
 while (apeynom <> 'ZZZ') do
  begin
   if (L= nil) then
    begin
     new(L);
     L^.dato:= cliente;
     L^.sig:= nil; 
    end;
   else begin
    new(aux);
    aux^.sig:= L;
    L:=aux;
   end; 
   leerCliente(cliente);
end

procedure imprimir (var A:arbol);
begin    
 if (A <> nil) then 
  begin
   imprimir (A^.HD);
   imprimir (A^.HI);
   writeln (A*.dato.dni);
  end;
end;

procedure agregarEnArbol (A:arbol; c:cliente);
begin    
 if (A = nil) then 
  begin
   new(A);
   A^.dato:= c;
   A^.HI:= nil;
   A^.HD:= nil;
  end
 else 
  if (c.dni <= A^.HI.dato) then agregarEnArbol(A^.HI, c);
  else
   agregarEnArbol(A^.HD,c); 
end.

procedure generarArbol (var L:lista; var A:arbol);
begin
 while (L^.sig <> nil) then
  begin
   agregarEnArbol(A, L.dato);
   L:= L^.sig;
  end;
end;

procedure mayorCategoria (A:arbol; var c:cliente);
begin
 if (A <> nil) then
 begin
  if (A*.HD <> nil) then
    mayorCategoria (A^.HD,c);
  else
    c = A^.dato;
 end;      
end;


VAR
 L:lista;
 A: arbol;
 c:cliente;
 
BEGIN
 cargarLista (L);
 generarArbol(L,A);	
 write ('Muestro los dni ordenados de menor a mayor');
 mostrarDNI(A);
 writeln;
 writeln;
 mayorCategoria(A,c); 	
 write('El cliente',c.apeynom, 'es el de mayor categora');
 readln;
END.

