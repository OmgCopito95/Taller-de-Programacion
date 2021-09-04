{1. El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa modularizado que:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De
cada oficina se ingresa el código de identificación, DNI del propietario y valor de la
expensa. La lectura finaliza cuando se ingresa el código de identificación -1, el cual no se
procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación
de la oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación
de la oficina.

}
program Hello;
const
    dimF = 300;
    fin = -1;
type
    rango = 1..dimF;
    oficina = record
        codIdentif:integer;
        dniProp:integer;
        valorExpensa:real;
    end;
    
vec_oficinas = array [rango] of oficina;

procedure leerOficina (var ofi: oficina);
begin
    with ofi do begin
        writeln('Codigo de identificación:');
        readln(codIdentif);
        if (codIdentif <> fin) then begin
            writeln('DNI del propietario:');
            readln(dniProp);
            writeln('Valor de la expensa $:');
            readln(valorExpensa);
        end;
    end;
end;
procedure cargarVector( var v: vec_oficinas; var dimL: integer );
var 
    ofi:oficina;
begin
   dimL := 0; //seteo en 0 la dimL
   writeln('---Ingrese la oficina---'); //ingreso la oficina
   leerOficina(ofi);
   while (ofi.codIdentif <> fin) and ( dimL < dimF ) do begin 
          dimL:= dimL + 1; //"agrando" la dimL
          v[dimL] := ofi; //inserto la oficina leídacv   en la posición de dimL
          writeln('---Ingrese la oficina---'); //leer oficina
          leerOficina(ofi);
   end;
End;

procedure OrdenarXInsercion(var vec: vec_oficinas; diml: integer);
var
    i, j: Integer;
    actual:oficina;
begin

    for i:=2 to dimL do begin
        actual:= vec[i]; //ver
        j:= i-1;
        while (j > 0) and (vec[j].codIdentif > actual.codIdentif) do begin
            vec[j+1] := vec[j];
            j:=j-1;
        end;
        vec[j+1] := actual;
    end;
end;

procedure ordenarXSeleccion (var vec:vec_oficinas; dimL:integer);
var i, j, p: integer;
    item : oficina;
        
begin
 for i:=1 to dimL-1 do begin {busca el mínimo y guarda en p la posición}
    p := i;
    for j := i+1 to dimL do
        if vec[ j ].codIdentif < vec[ p ].codIdentif then p:=j;
         {intercambia v[i] y v[p]}
    item := vec[ p ];   
    vec[ p ] := vec[ i ];   
    vec[ i ] := item;
 end;
end;

procedure imprimirArreglo(vec:vec_oficinas; dimL:integer);
var
    i:integer;
begin
    for i:=1 to dimL do
        write('|',vec[i].codIdentif,' ',vec[i].dniProp,' ',vec[i].valorExpensa:4:2);
    writeln('|');
end;
var
    vecOfi:vec_oficinas;
    dimL:integer;

begin
    cargarVector(vecOfi,dimL);
    //ordenarXInsercion(vecOfi,dimL);
   // imprimirArreglo(vecOfi,dimL);
    ordenarXSeleccion(vecOfi,dimL);
    imprimirArreglo(vecOfi,dimL);
end.
