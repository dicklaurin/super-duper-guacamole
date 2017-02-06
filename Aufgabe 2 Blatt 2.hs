data MultTree a = Leaf a | Knot a a ([MultTree a])   deriving Show 

t1 :: MultTree Int
t1 = Knot 3 42[Knot 3 15[Leaf 3, Leaf 11, Leaf 12] , Knot 19 42[Leaf 42, Leaf 23]]



verzweigungKnoten:: MultTree Int -> Int
verzweigungKnoten x y [] = 0
verzweigungKnoten x y (a:[]) = 1
verzweigungKnoten x y (a:b:[])= 2
verzweigungKnoten x y (a:b:c) = 1+ verzweigungKnoten x y (b:c) 
verzweigungKnoten x =0



verzweigungsgrad :: MultTree Int -> Int
verzweigungsgrad x y (a:b) = Prelude.max(verzweigungKnoten this , verzweigungKnoten a, verzweigungsgrad b)
verzweigungsgrad x y [] =0
verzweigungsgrad x =0
verzweigungsgrad (a:b) = Prelude.max (verzweigungsgrad a, verzweigungsgrad b)
--für jeden Knoten wird die verzweigungszahl mit verzweigungKnoten berechnet.

datenListe :: MultTree Int -> [Int]
datenListe x y (a:[]) = datenListe a
datenListe x y ([]) = Nil
datenListe x y (a:b)= datenListe a ++ datenListe b
datenListe x = [x]

--datenIntervalle :: MultTree Int -> MultTree Int
--datenIntervalle x y (a:b) = if (datenLesen (a:b) ) then if (x>listenMin(datenIntervalle a:b) && y<listenMax(datenIntervalle a:b) ) then listenMin(datenIntervalle a:b) listenMax(datenIntervalle a:b) (a:b) else if y<listenMax(datenIntervalle a:b) then x listenMax(datenIntervalle a:b) (a:b)   else if x>listenMin(datenIntervalle a:b) then listenMin(datenIntervalle a:b) y (a:b) else () else x y (datenIntervalle a : datenIntervalle b)
-- ganz kurz gefasst ist diese geschachtelte if klammer so aufgebaut: wenn die nachfolger vom jetzigen Knoten blätter sind wird nach den höchsten und niedrigsten Werten geschaut und dann die rekursion in den jeweiligen Fällen fortgeführt. 
-- z.B. wenn eine zahl größer als y ist, wird  x (die zahl die größer als y und das maximum der Liste ist, die von datenIntervalle ausgegeben wird ist) (a:b) ausgegeben. wenn keine blätter getroffen werden, wird datenIntervalle der Nachfolger aufgerufen.

datenIntervalle x y [] =Knot MinBound MaxBound []
datenIntervalle x y (a:b) = Knot ListenMin(datenIntervalle a:datenIntervalle b) ListenMax (datenIntervalle a: datenIntervalle b) (datenIntervalle a:datenIntervalle b)
-- Wir schaffen einen Knoten, dessen x = das minimum der nachfolgenden Knoten ist. y same. die liste der nachfolger dient dazu, die nachfolgenden Knoten genauso zu berechnen. Blätter bleiben durch datenIntervalle x = x erhalten.
datenIntervalle x = x
datenIntervalle (a:b) = datenIntervalle a ++ datenIntervalle b
datenIntervalle (a:[]) = datenIntervalle a

--datenLesen:: [MultTree Int]-> Bool
{-datenLesen [x]= datenLesen x
datenLesen x y [z] = false
datenLesen (x:[]) = true
datenLesen (x: b) =  datenLesen b -}

listenMin :: [Int] -> Int
listenMin (a:[]) = a
listenMin (a:b:c) = if(a>b) then listenMin (b:c) else listenMin (a:c)

listenMax :: [Int] -> Int
listenMax (a:[]) = a
listenMax (a:b:c) = if(a<b) then listenMax (b:c) else listenMax (a:c)