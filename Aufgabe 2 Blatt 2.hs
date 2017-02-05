data MultTree a = Leaf a | Knot a a ([MultTree a])   deriving Show 

t1 :: MultTree Int
t1 = Knot 3 42[Knot 3 15[Leaf 3, Leaf 11, Leaf 12] , Knot 19 42[Leaf 42, Leaf 23]]



verzweigungKnoten:: MultTree  -> Int
verzweigungKnoten x y [] =0
verzweigungKnoten x y (a:b:[])=2
verzweigungKnoten x y (a:b:c) = 1+ verzweigungKnoten x y (b:c) 



verzweigungsgrad :: MultTree -> Int
verzweigungsgrad x y (a:b) = max(verzweigungKnoten this , verzweigungKnoten a, verzweigungsgrad b)
verzweigungsgrad x y [] =0
verzweigungsgrad x =0
verzweigungsgrad (a:b) = Prelude.max (verzweigungsgrad a, verzweigungsgrad b)


datenListe :: MultTree -> [Int]
datenListe x y (a:[]) = datenListe a
datenListe x y ([]) = Nil
datenListe x y (a:b)= datenListe a ++ datenListe b
datenListe x = [x]

datenIntervalle :: MultTree -> MultTree
datenIntervalle x y (a:b) = if (datenLesen (a:b) ) then ((if (x>ListenMin(datenIntervalle a:b))  then x = datenIntervalle a),  (if y<ListenMax(datenIntervalle a:b) then (let y=a )) ) else (datenIntervalle a, datenIntervalle b)
datenIntervalle x = x
datenIntervalle (a:b) = datenIntervalle a ++ datenIntervalle b
datenIntervalle (a:[]) = datenIntervalle a

datenLesen [MultTree] -> Bool
datenLesen ((x y [z]): b) = false
datenLesen x = true
datenlesen (x: b) =  datenLesen b

ListenMin :: [Int] -> Int
ListenMin (a:[]) = a
ListenMin (a:b:c) = if(a>b) then ListenMin (b:c) else ListenMin (a:c)

ListenMax :: [Int] -> Int
ListenMax (a:[]) = a
ListenMax (a:b:c) = if(a<b) then ListenMax (b:c) else ListenMax (a:c)