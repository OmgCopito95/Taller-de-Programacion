program punto5;

	const

		dimF = 5;

	type

		vNumeros = array [1..dimF] of integer;

//------------------------------PUNTO A------------------------------//
procedure cargarVector(var v: vNumeros);
var
	i, n: integer;
begin
	for i:= 1 to dimF do begin
		//write('Ingrese un numero: ');
		//readln(n);
		n:= random(100);
		writeln('Ingrese un numero: ', n);
		v[i]:= n;
	end;
end;


//------------------------------PUNTO B------------------------------//
//procedure encontrarMax(v: vNumeros; var max, pos: integer);
//begin
//	if(pos < dimF) then begin
//		if(v[pos] > max) then
//			max:= v[pos];
//		pos:= pos + 1;
//		encontrarMax(v, max, pos);
//	end
//	else
//		pos:= pos;
//		max:= max;
//end;

function encontrarMax(v: vNumeros; max, i: integer): integer;
begin
	if(i <= dimF) then begin
		if(v[i] > max) then
			max:= v[i];
		i:= i + 1;
		encontrarMax:= encontrarMax(v, max, i);
	end
	else
		encontrarMax:= max;
end;


function sumador (v:vNumeros;suma:integer;pos:integer):integer;
begin
  if(pos<1)or(pos>dimf)then begin
    sumador:= suma;
  end
  else begin
    suma:=suma+v[pos];
    sumador:= sumador (v,suma,(pos+1));
  end;
end;



//------------------------------PUNTO C------------------------------//
function sumarValores(v: vNumeros; i, suma: integer): integer;
begin
	if(i <= dimF) then begin
		suma:= suma + v[i];
		i:= i+1;
		sumarValores:= sumarValores(v, i, suma);
	end
	else
		sumarValores:= suma;
end;


//------------------------------PROGRAMA PINCIPAL------------------------------//
var
	vector: vNumeros;
	vMAx, pos, suma: integer;
begin
    Randomize;
	vMAx:= -1;
	pos:= 1;
	suma:= 0;

//------------------------------PUNTO A------------------------------//
	cargarVector(vector);

	writeln();

//------------------------------PUNTO B------------------------------//
	//encontrarMax(vector, vMAx, posMax);

	//writeln('El valor maximo del vector es: ', vMAx, ' en la posicion ', posMax);

	writeln('El valor maximo del vector es: ', encontrarMax(vector, vMAx, pos));

	writeln();

//------------------------------PUNTO C------------------------------//
	writeln('La suma de todos los valores del vector es: ', sumarValores(vector, pos, suma));

	writeln();

	write('PRESIONE ENTER PARA CERRAR EL PROGRAMA');
	readln();
end.







