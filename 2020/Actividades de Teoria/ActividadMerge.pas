{*  **********************  ACTIVIDAD ************************
*
*
* El programa intenta dar solución al siguiente enunciado.
* 
* El programa no funciona. Tiene módulos incompletos y errores.
* Solucione y complete el código e manera tal que resuelva el problema. 
* 
* 
* Para confirmar que funciona debe realizar las pruebas necesarias   
* 
* 
* ---------------------------------------------------------------------
* ENUNCIADO
* Una empresa de logistica tiene 3 sucursales. Cada sucursal envía paquetes 
* a diferentes localiades de la Provincia de Bs. As.
* 
* Cada sucursal dispone de un listado de los paquetes enviados ordenada 
* por localidad de destino. De cada paquete se conoce: localidad, peso y 
* costo.  
* 
* Se desea totalizar la cantidad de paquetes enviados a cada localidad y 
* el monto total facturado para cada una.
* 
* Se pide: 
*  - Informar para cada localidad cantidad de paquetes y ganancia total.
*  
* ---------------------------------------------------------------------
* 
* --------------------------------------------------------------------
* NOTA
* * Se creo una estructura adicional (nombreLocalidad) para que puedan hacer 
* * un random y puedan probar con strings aleatorios **
* * Es algo opcional, solo para que les facilite las pruebas
* --------------------------------------------------------------------
* 
* 
* 
* }

program Ejercicio;

CONST 
	MAX = 3; //cantidad de sucursales
	
TYPE 
	subrango = 1 .. MAX;
	  
	paquete = record
	  localidad: string;
	  costo: real;
	  peso: integer;
	end; 
	
	lista = ^nodo;
	nodo = record
		dato: paquete;
		sig: lista;
	end;
	
	sucursales = array[subrango] of lista;
	
	
	//Lista nueva
	totalLocalidad = record
	  nombre: string;
	  cantidadPaquetes: integer;
	  ganancia: real;
	end;
		
	listaNueva = ^nodoNuevo;
	nodoNuevo = record
	  dato: totalLocalidad;
	  sig: listaNueva;
	end;




    //Estructura para cargar estantes de manera automatica
	nombreLocalidad = array[1..10] of string;
	



//----------------------------------------------------------------------	
// ---------------CARGA ESTRUCTURA--------------------------------------
 	
procedure generarNombreLocalidad(var nom: nombreLocalidad);
begin
	nom[1] := 'Adrogue';
	nom[2] := 'Burzaco';
	nom[3] := 'Claypole';
	nom[4] := 'Don Orione';
	nom[5] := 'Glew';
	nom[6] := 'Avellaneda';	
	nom[7] := 'Longchamps';
	nom[8] := 'Rafael Calzada';	
	nom[9] := 'La Plata';
	nom[10] := 'General Alvear';
end;	


procedure insertarOrdenado(var L: lista; p: paquete);
var
  act, ant, aux: lista;
begin
   //INSERTAR ORDENADO
end;



procedure cargarPaquetes(var todos: sucursales);
var
	e: subrango;
	i: integer;
	nomLoc: nombreLocalidad;
	p: paquete;
begin
  generarNombreLocalidad(nomLoc);
  randomize;
  for i:= 1 to 20 do begin  // En esta prueba nos aseguramos 20 gastos. Podriamos usar  while posNom <> 0
	e:= random(MAX);
	p.localidad:= nomLoc[random(10)+1];  //random de 0 a 9
	p.costo:= random(1000) + random(); //random sin parametro retorna valores reales enre 0 y 1.
	
	insertarOrdenado(todos[e], g);
  end;
end;

// ----------------------FIN CARGA ESTRUCTURA---------------------------
//----------------------------------------------------------------------

	
	
procedure inicializar( var todos: sucursales);
var 
	i: subrango;
begin
	for i:= 1 to MAX do begin
	  todos[i]:= NIL;
	 end;
end;	





//----------------------------------------------------------------------
//--------------------------IMPRIMIR-----------------------------------

procedure imprimirLista(var l: lista); //<-- parametro por referencia ¿? 
begin
	while(l <> nil) do begin
	  writeln ('- Destino: ', l^.dato.localidad, ' - Peso: ',l^.dato.peso,'kg.  - $', l^.dato.costo:1:2 ); 
	  l:= l^.sig;
	end;
end;

procedure mostrarPaquetes(var todos: sucursales); //<-- parametro por referencia ¿?
var
	i: subrango;
begin
   writeln('-----------------------------------');	
  writeln('-------- SURCURSALES --------------');	
  writeln('-----------------------------------');	
  writeln(' ');	
  for i:= 1 to MAX do begin
	writeln(' -------------- ');
	writeln('SUCURSAL ',i, ' - PAQUETES ');
	writeln(' -------------- ');
	imprimirLista(todos[i]);
	end;
end;


procedure imprimirListaNueva( l: listaNueva);
begin
	while(l <> nil) do begin
	  writeln ('- Destino: ', l^.dato.nombre, ' - Cant: ',l^.dato.cantidadPaquetes,'  - $', l^.dato.ganancia:1:2 ); 
	  l:= l^.sig;
	end;
	writeln(' ---------- ');
end;


//--------------------------FIN IMPRIMIR--------------------------------
//----------------------------------------------------------------------

	
	
	
	
	
	
	
//------------------------------------------------------------------
//---------------------------MERGE--------------------------------------

procedure AgregarAtras(var L,ult: listaNueva; t: totalLocalidad);
var
	aux: listaNueva;
begin
	//Agregar atras
end;




procedure determinarMinimo(var todos: sucursales; var pMin: paquetes); //todos va por referencia, sino no termina nunca
var
  i, sucMin: subrango;
  
begin
  
  pMin:= 'ZZZ';
  
  for i:= 1 to MAX do begin
	if(todos[i] <> NIL)then begin
		if(todos[i]^.dato.localidad < pMin)then begin
				pMin:= todos[i]^.dato.localidad; 
				sucMin:= i;
		end;
	end;
  end;
  
  if(pMin <> 'ZZZ')then
	todos[sucMin] := todos[sucMin]^.sig;
end;





procedure merge(var nuevaL: nuevaLista; todos: sucursales); 
var
  pMin: paquete; 
  pActual: totalLocalidad; 
  ult: nuevaLista;
begin
  
  determinarMinimo(todos, pMin);
  
  while(// COMPLETAR  )do begin  
	
	pActual.nombre := pMin.nombre;  
	pActual.ganancia := 0;
	pActual.cantidadPaquetes:= 0;
	
	while(// COMPLETAR  )do begin // corte de control por nombre de localidad
		pActual.cantidadPaquetes:= pActual.cantidadPaquetes +1; 
		pActual.ganancia := pActual.ganancia + pMin.costo;
		
    end;
    agregarAtras(nuevaL, ult, ); //agrego el total de la localidad que terminé de procesar
  end;
  
end;
//----------------------------FIN MERGE --------------------------------
//----------------------------------------------------------------------	
	
	
	
//----------------------------------------------------------------------
//-------------------------PROG PPAL------------------------------------	
VAR 
		todos : gastos;
		nuevaL : nuevaLista;
BEGIN
	inicializar(todos);
	cargarPaquetes(todos);
	mostrarPaquetes(todos);
	merge(nuevaL, todos);
	writeln(' ');
	writeln(' ');
	writeln('-----------------------------------');
	writeln('    TOTALES POR LOCALIDAD');
	writeln('-----------------------------------');
	imprimirListaNueva(nuevaL);
	
end.		
