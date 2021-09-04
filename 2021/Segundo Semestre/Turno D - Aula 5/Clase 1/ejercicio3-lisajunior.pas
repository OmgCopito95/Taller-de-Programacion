{Una librería requiere el procesamiento de la información de sus productos. De cada
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
d. Muestre los precios del vector ordenado.}


Program Ejer3;

	type
		subrango=1..8;
		productos=record           //NOMBRE DEL REGISTRO EN SINGULAR
				  Codigo:integer;
				  CodRubro:subrango;
				  precio:real;
		end;
		lista=^nodo;
		nodo=record
			 datos:productos;
			 sig:lista;
		end;
		VectorRubro = array [subrango] of lista;
		Vector30=array [1 .. 30] of productos;     //HACER REGISTRO NUEVO PARA NO GUARDAR DATO REDUNDANTE DE RUBRO=3 EN TODOS
		


	Procedure LeerProductos (var p:productos);
			 begin
				  with p do begin
					  writeln('ingrese el precio del producto:');
					  readln(precio);
					  If(precio<>0)then begin
						writeln('Ingrese el cod del producto:');
						readln(Codigo);				 
						writeln('Ingrese el Codigo del Rubro:');
						readln(CodRubro);
					  end;
				  end;
			 end;
			 
			 
	Procedure ArmarNodos (var l:lista; p:productos);
			  var
				 ant,nue,act:lista;
			  begin
				   new(nue);
				   nue^.datos:=p;
				   act:=l;
				   ant:=l;
				   while((act<>nil) and (act^.datos.Codigo < p.Codigo)) do begin
						ant:=act;
						act:=act^.sig;
				   end;
				   If(ant=act)then
					  l:=nue
				   else
					   ant^.sig:=nue;
				   nue^.sig:=act;
			  end;
			  
			  
	Procedure InicializarVecRubro (var vecR:VectorRubro);
			  var 
				 i:integer;
			  begin
				   for i:=1 to 8 do begin
					   vecR[i]:=nil;
				   end;
			  end;
			  
			  
			  
	Procedure ArmarVecRubro (var VecR:VectorRubro);
			  var
				 p:productos;
			  begin
				   LeerProductos(p);
				   While(p.precio<>0)do begin
						ArmarNodos(vecR[p.CodRubro],p);						
						LeerProductos(p);
				   end;
			  end;
			  
	Procedure ImprimirVecRubro (VecR:vectorRubro);
			  var																
				 i:integer;
			  begin
					For i:= 1 to 8 do begin
						writeln('-------Inicio del Rubro ',i,'--------');
						while (VecR[i] <> nil) do begin                           //MODULARIZAR RECORRIDO DE LA LISTA
							  writeln('Codigo: ',VecR[i]^.datos.CodRubro);
							  VecR[i]:=VecR[i]^.sig
						end;
					end;
			  end;																
	

	Procedure GenerarVec (var v:vector30; VecR:vectorRubro; var dimL:integer);   //EN VEZ DE PASAR TODO EL VECTOR DE RUBROS, MANDAR SOLO LA LISTA DE LA POSICION 3
			  begin
				   dimL:=0;
				   While (VecR[3] <> nil) and  ( dimL < 30 )do begin 				
						dimL:=dimL+1;
						v[dimL]:=VecR[3]^.datos;
						VecR[3]:=VecR[3]^.sig;
				   end;
			 end;    
			 
				  
	Procedure OrdenarVec (var v:vector30; dimL:integer);
			 var 
				i,j:integer; p:productos;
			 begin
				  for i:=2 to dimL do begin
					 p:=v[i];
					 j:=i-1;
					 while(j>0) and (v[j].precio > p.precio) do begin
						v[j+1]:=v[j];
						j:=j-1;
					end;
					v[j+1]:=p;
				  end;
			end;
			
			
   Procedure ImprimirPrecio (v:vector30; dimL:integer);
			 var
				i:integer;
			 begin
			      writeln('-------Precios----------');
				  for i:= 1 to dimL do begin
					 writeln(' Precio del producto: ',v[i].Codigo,' : ',v[i].Precio:2:2);
					 writeln(' ');
				  end;
			 end;
			 
			 
			 
var
   v30:vector30;
   dimL:integer;
   vecR:VectorRubro;
begin
	InicializarVecRubro(vecR);
	ArmarVecRubro(VecR);
	ImprimirVecRubro(VecR);
	GenerarVec(v30,VecR[3],dimL);
	OrdenarVec(v30,dimL);
	ImprimirPrecio(v30,dimL);
end.
	
				      
