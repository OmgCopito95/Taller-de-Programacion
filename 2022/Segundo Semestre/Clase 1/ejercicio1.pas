// Implementar un módulo que permita leer una secuencia de caracteres terminada en punto y los almacene en un vector con dimensión física igual a 10.

program ejercicio1;
uses crt;
const
    MAX = 10;
type

    vector = array[1..MAX] of char;

    procedure leer(var v: vector);
    var
        i: integer;
        dato: char;
    begin
        // leer la secuencia de caracteres con un while hasta que se encuentre un punto
        i:=0;
        readln(dato);
        while (dato <> '.') do
        begin
            i := i + 1;
            v[i] := dato;
            readln(dato);
        end;
    end;

    // b. Implementar un módulo que imprima el contenido del vector.
    procedure imprimir(v: vector);
    var
        i: integer;
    begin
        for i := 1 to MAX do
            writeln(v[i]);
    end;

    // c. Implementar un módulo recursivo que imprima el contenido del vector.
    procedure imprimir_rec(v: vector; i: integer);
    begin
        if (i < MAX) then begin
            writeln(v[i]);
            imprimir_rec(v,i+1);
        end;
    end;

    //d. Implementar un módulo recursivo que permita leer una secuencia de caracteres terminada en punto y retorne la cantidad de caracteres leídos.
    function cantidad_caracteres(): integer;
    var
        dato: char;
    begin
        readln(dato);
        if (dato <> '.') then
            cantidad_caracteres:=1+cantidad_caracteres()
        else
            cantidad_caracteres:=0;
    end;

    

var
    v: vector;

begin
    // leer la secuencia de caracteres
    leer(v);

    // imprimir el contenido del vector
    writeln('imprime vector normal');
    imprimir(v);

    // imprimir el contenido del vector recursivamente
    writeln('imprime vector recursivo');
    imprimir_rec(v,1);

    // imprimir la cantidad de caracteres leídos
    writeln('cantidad de caracteres leídos: ', cantidad_caracteres());

    readln;

end.




