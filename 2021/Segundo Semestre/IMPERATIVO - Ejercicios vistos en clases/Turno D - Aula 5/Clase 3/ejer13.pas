{Un teatro tiene funciones los 7 días de la semana. Para cada día se tiene una lista con las
entradas vendidas. Se desea procesar la información de una semana.

Implementar un programa que:
a. Genere 7 listas con las entradas vendidas para cada día. De cada entrada se lee día (de 1
a 7), código de la obra, asiento y monto. La lectura finaliza con el código de obra igual a 0.
Las listas deben estar ordenadas por código de obra de forma ascendente.
b. Genere una nueva lista que totalice la cantidad de entradas vendidas por obra. Esta lista
debe estar ordenada por código de obra de forma ascendente.}

	Program Ejercicio13;

	const
		DIAS=7;
	type
		semana=1..7;
		
		entrada=record
				dia:semana;
				CodObra:integer;
				asiento:integer;
				monto:real;
		end;
		
		total=record
			  Obra:integer;
			  eTotal:integer;
		end;
		
		lista=^nodo;
		
		nodo=record
			 dato:entrada;
			 sig:lista;
		end;
		
		listaT=^nodoT;
		
		nodoT=record
			  datoT:total;
			  sigT:listaT;
		end;
		
		
		
	VectDias= array [semana] of lista;
	
//----------------------------------------------------------------------

	Procedure LeerEntradas (var e:entrada);
			begin
				with e do begin
					Writeln('Ingrese el Codigo de la obra');
					readln(CodObra);
					If (CodObra <> 0) then begin
						Writeln('Ingrese el dia');
						readln(dia);
						Writeln('Ingrese el asiento');
						asiento:=random(51);
						Writeln('Ingrese el monto');
						readln(monto);
					end;
				end;
			end;
			
//----------------------------------------------------------------------


	Procedure OrdenarNodos ( var l:lista; e:entrada);
			var
				ant,act,nue:lista;
			begin
				new(nue);
				nue^.dato:=e;
				act:=l;
				ant:=l;
				while(act<>nil) and (act^.dato.CodObra < e.CodObra) do begin
					 ant:=act;
					 act:=act^.sig;
				end;
				If(ant=act)then
				  l:=nue
				else
					ant^.sig:=nue;
				nue^.sig:=act;
			end;

//----------------------------------------------------------------------	



	Procedure InicializarVec(var vd:VectDias);
			 var 
				i:integer;
			 begin
				  for i:=1 to DIAS do 
					 vd[i]:=nil;
			end;		

//---------------------------------------------------------------------- [NO PROCESA LA PRIMER OBRA PERO EN EL MERGE APARECE]
	
	Procedure ArmarListasV (var vd:VectDias);
			var
				e:entrada;
			begin
				 LeerEntradas(e);
				 while(e.CodObra <> 0)do begin
					 OrdenarNodos(vd[e.dia],e);
					 LeerEntradas(e);
				 end;
			 end;		 
			 
			 
			 
			 
	Procedure ImprimirListas(vd:VectDias);
			var
				i:integer;
			begin
				for i:= 1 to DIAS do begin
					If(vd[i] <> nil)then begin
						writeln('codobra:  ',vd[i]^.dato.CodObra);
						writeln('dia:  ',vd[i]^.dato.dia);
						vd[i]:=vd[i]^.sig;
					end;
				end;
			end;

//---------------------------------------------------------------------- 


	Procedure minimo (var vd:VectDias; var minObra:integer);
			Var
				indiceMin,i:integer;
			Begin
				minObra:= 999;
				indiceMin:= -1;
				for i:= 1 to DIAS do
					if (vd[i] <> nil) then 
						if (vd[i]^.dato.CodObra <= minObra) then begin
							indiceMin:= i;
							minObra:= vd[i]^.dato.codObra;  
						end; 
				if (indiceMin <> -1) then 
					vd[indiceMin]:= vd[indiceMin]^.sig;
			End;
			
			
	Procedure AgregarAtras (var l,ult:listaT; minO:integer; entradasT:integer);
				var
					nue:listaT;
				begin
					new(nue);
					nue^.datoT.Obra:=minO;
					nue^.datoT.etotal:=entradasT;
					nue^.sigT:=nil;
					If(l <> nil) then
						ult^.sigT:=nue
					else
						l:=nue;
					ult:=nue;
				end;
				
				
	Procedure merge (vd:VectDias; var NuevaL:listaT);
	var
		TodasE,MinObra,act:integer;
		ult:listaT;
Begin
  NuevaL:= nil;
  minimo (vd,MinObra);
  while (MinObra <> 999) do begin
     TodasE:=0;
     act:= minObra;
     while ((minObra <> 999) and (minObra = act) )do begin
        TodasE:= TodasE + 1;
        minimo (vd,minObra);
     end;
     agregarAtras(NuevaL,ult,act,TodasE);
    end;
End;  
			
	
//-----------------------------------------------------------------------



	Procedure ImprimirMerge (NuevaL:listaT);
				begin
					writeln('-----------IMPRIME NUEVO VECT-------------');
					while(NuevaL <> nil) do begin
						Writeln('Para la obra numero: ',NuevaL^.datoT.Obra);
						Writeln('Se vendieron: ',NuevaL^.datoT.eTotal);
						NuevaL:=NuevaL^.sigT;
					end;
				end;



//----------------------------------------------------------------------

	var
		NuevaL:listaT;
		vd:VectDias;
	begin
		InicializarVec(vd);
		ArmarListasV(vd);
		ImprimirListas(vd);
		Merge(vd,NuevaL);
		ImprimirMerge(NuevaL);
	end.
