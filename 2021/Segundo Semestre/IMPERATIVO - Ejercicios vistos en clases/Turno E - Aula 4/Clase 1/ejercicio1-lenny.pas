{El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa modularizado que:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra.
De cada oficina se ingresa:
el código de identificación
DNI del propietario 
y valor de la expensa. 
La lectura finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.
b. Ordene el vector, aplicando el método de inserción, por código de identificación de la oficina.
c. Ordene el vector aplicando el método de selección, por código de identificación de la oficina.}

program practica1_punto1;
const
 dimf=5;
type
  rango=1..dimf;
  ofi=record
    cod:integer;
    dni:integer;
    expensa:real;
  end;

  vector= array [rango]of ofi;

  //procesos
  procedure leer_ofi(var datos:ofi);
  begin
    readln(datos.cod);
    if(datos.cod<>-1)then begin
      readln(datos.dni);
      readln(datos.expensa);
    end;
  end;

  procedure cargar_vector(var v:vector ; var diml:integer);
  var
  info:ofi;
  begin
    leer_ofi(info);
    while (info.cod <> -1)and(diml<dimf)do begin
      diml:=diml+1;
      v[diml]:=info;
      leer_ofi(info);
    end;
  end;

  procedure ordenar_seleccion (var v:vector; diml:integer); // ordenacion de seleccion
  var
  i:integer;
  j:integer;
  pos:integer;
  info :ofi;
  begin
    for i := 1 to diml-1 do begin 
      pos:= i;
      for j:= i+1 to diml do begin
        if (v[j].cod < v[pos].cod)then begin
          pos:=j; 
        end;
      end;
        info:= v[pos]; 
        v[pos]:= v[i];  
        v[i]:= info;
    end;
  end;


 procedure ordenar_inserccion (var v :vector ; diml:integer); // por insercion
 var
 i:integer;
 j:integer;
 actual:ofi;
 begin
   for i := 2 to diml do begin 
     actual:=v[i];  
     j:=i-1;     
     while (j>0) and (v[j].cod > actual.cod) do begin    
       v[j+1]:=v[j];
       j:=j-1;
     end;
     v[j+1]:=actual;
   end;              
 end;

  procedure imprimir_vector(v:vector; diml:integer);
  var
  i: integer;
 begin
    writeln('---------------------- ');
    for i := 1 to diml do begin
      writeln('codigo: ',v[i].cod);
      {writeln('dni: ',v[i].dni);
      writeln('expensas: ',v[i].expensas)}
    end;
    writeln('-----------------------');
  end;  

  //programa principal
  var
   v :vector;
   diml:integer;
   num:integer;
  begin
    diml:=0;
    cargar_vector(v,diml); //A
    writeln('ingrese el numero 1 si quiere ordenar por seleccion o ingrese el numero 2 si quiere ordenar por insercion');
    readln(num);
    if(num=1)then begin
      ordenar_seleccion(v,diml); //B
    end
    else begin
      if(num=2)then begin
        ordenar_inserccion(v,diml);
      end
      else begin
        writeln('No ingreso un numero valido vuelva a intentar.');
      end; 
    end;  
    if (num=1)or(num=2)then begin
      imprimir_vector(v,diml);
    end;  
  end.

