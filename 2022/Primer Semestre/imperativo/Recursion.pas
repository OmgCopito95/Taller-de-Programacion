program CalculoDigitoMaximoRec;
type digito=-1..9;

var num: integer;
    max: digito;

procedure digitoMaximoRec(n: integer; var max: digito);
var
  dig: integer;
begin
  if (n <> 0) then begin
                dig:= n mod 10;
                if (dig > max) then
                                max:= dig;
                n:= n div 10;
                digitoMaximoRec(n, max);
              end;
end;

begin
  read (num);
  max := -1;
  digitoMaximoRec(num, max);
  write ('El digito maximo de ', num, ' es: ', max);
  readln;
  readln;
end.

