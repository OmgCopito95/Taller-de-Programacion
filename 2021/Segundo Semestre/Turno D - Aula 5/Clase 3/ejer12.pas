{Implementar un programa que procese la información de las ventas de productos de una
librería que tiene 4 sucursales. De cada venta se lee fecha de venta, código del producto
vendido, código de sucursal y cantidad vendida. El ingreso de las ventas finaliza cuando se
lee el código de sucursal 0.
Implementar un programa que:
a. Almacene las ventas ordenadas por código de producto y agrupados por sucursal,
en una estructura de datos adecuada.
b. Contenga un módulo que reciba la estructura generada en el punto a y retorne
una estructura donde esté acumulada la cantidad total vendida para cada código de
producto.}


	Program Ejer12;
	
	const
		 SUCUR=4;
		 FIN=0;
	type
		Sucursales=0..4;
		dias=1..31;
		meses=1..12;
		anios=2000..2021;
		
		Fecha=record
			  dia:dias;
			  mes:meses;
			  anio:anios;
		end;
		
		
		venta=record
			  Fechav:fecha;
			  CodProducto:integer;
			  CodSucursal:Sucursales;
			  CantVendida:integer;
		end;
		
		VentaM=record
			   CantTotal:integer;
			   CodProductoM:integer;
		end;
		
		lista=^nodo;
		
		nodo=record
			 dato:venta;
			 sig:lista;
		end;
		
		listaM=^nodoM;
		
		nodoM=record
			  datoM:ventaM;
			  sigM:listaM;
		end;
	
	                             1..4
		VectSucursales= array [Sucursales] of lista;
	
	
	
//----------------------------------------------------------------------


	Procedure LeerFecha (var f:fecha);
			begin
				with f do begin
					Writeln('Ingrese el dia');
					dia:=random(32);
					Writeln('Ingrese el mes');
					mes:=random(13);
					Writeln('Ingrese el anio');
					anio:=random(2021);
				end;
			end;
			
			
	Procedure LeerVenta (var v:venta);
			var
				f:fecha;
			begin
				with v do begin;
					writeln('Ingrese el Codigo de sucursal');
					readln(CodSucursal);
					If (CodSucursal <> FIN)then begin
						LeerFecha(f);
						v.fechav:=f;
						writeln('Ingrese el Codigo de Producto Vendido');
						readln(CodProducto);
						Writeln('Ingrese la cantidad vendida');
						readln(CantVendida);
					end;
				end;
			end;



//----------------------------------------------------------------------


	Procedure OrdenarNodos ( var l:lista; v:venta);
			var
				ant,act,nue:lista;
			begin
				new(nue);
				nue^.dato:=v;
				act:=l;
				ant:=l;
				while(act<>nil) and ( act^.dato.CodProducto < v.CodProducto) do begin
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


	Procedure InicializarVec(var vs:VectSucursales);
			 var 
				i:integer;
			 begin
				  for i:=1 to SUCUR do 
					 vs[i]:=nil;
			end;
	
//------------------------------------------------------------------------



	Procedure ArmarListasV (vs:VectSucursales); //mandar por referencia
			var
				v:venta;
			begin
				 LeerVenta(v);
				 while(v.CodSucursal <> FIN)do begin
						OrdenarNodos(vs[v.CodSucursal],v);
						LeerVenta(v);
				    end;
			end;
			
//-----------------------------------------------------------------------------------------------------------------Lista nueva---------------------------------------------------


	Procedure minimo (var vs:VectSucursales; var vm:ventaM);
			var
				nodo,i:integer;
			begin
				vm.CodProductoM:=999;
				nodo:=-1;
				for i:= 1 to SUCUR do begin
					If ((vs[i] <> nil) and (vs[i]^.dato.CodProducto <=  vm.CodProductoM)) then begin
						vm.CodProductoM:=vs[i]^.dato.CodProducto;
						nodo:=i;
					end;
				end;
				If(nodo <> -1)then begin
				  vm.CantTotal:=vs[nodo]^.dato.CantVendida;
				  vs[nodo]:=vs[nodo]^.sig;
				end;
			end;



	Procedure AgregarAtras (var l,ult:listaM; codP:integer; montoT:integer);
				var
					nue:listaM;
				begin
					new(nue);
					nue^.datoM.CodProductoM:=codP;
					nue^.datoM.CantTotal:=MontoT;
					nue^.sigM:=nil;
					If(l <> nil) then
						ult^.sigM:=nue
					else
						l:=nue;
					ult:=nue;
				end;
				
	Procedure Merge (vs:VectSucursales; var Nueval:listaM);
			 var
				act,MontoT:integer;
				ult:listaM;
				vm:ventaM;
                ventaActual:ventaM;  //registro que guarda el actual
			begin
				Nueval:=nil;
				minimo(vs,vm);
				while (vm.CodProductoM <> 999) do begin
					act:=vm.CodProductoM; //ventaActual.codProd:=vm.CodProductoM
					MontoT:=0;  //ventaActual.MontoT:=0;
					while(vm.CodProductoM <> 999) and (act =  vm.CodProductoM) do begin
						 MontoT:= MontoT + vm.CantTotal;
						 minimo(vs,vm);
					end;
					AgregarAtras(nueval,ult,act,MontoT);
				end;                       //ventaActual
			end;
				
				
				
				
//----------------------------------------------------------------------



		Procedure ImprimirMerge (NuevaL:listaM);
				begin
					writeln('-----------IMPRIME NUEVO VECT-------------');
					while(NuevaL <> nil) do begin
						Writeln(NuevaL^.datoM.CodProductoM);
						Writeln(NuevaL^.datoM.CantTotal);
						NuevaL:=Nueval^.sigM;
					end;
				end;
				
				
			 
//-----------------------------------------------------------------------

var
	vs:VectSucursales;
	nuevaL:ListaM;
begin
	InicializarVec(vs);
	ArmarListasV(vs);
	Merge(vs,nuevaL);
	ImprimirMerge(NuevaL);
end.
	
