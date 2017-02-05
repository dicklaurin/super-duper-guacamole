data MultTree a = Leaf a | Knot a a ([MultTree a])   deriving Show 

t1 :: MultTree Int
t1 = Knot 3 42[Knot 3 15[Leaf 3, Leaf 11, Leaf 12] , Knot 19 42[Leaf 42, Leaf 23]]

verzweigungsgrad:: MultTree a -> Int
verzweigungsgrad x y []= 0
verzweigungsgrad x =0
verzweigungsgrad x y (a:b) = if verzweigungsgrad a + verzweigungsgrad b==0 then verzweigungKnoten else max (verzweigungsgrad a, verzweigungsgrad b)


verzweigungKnoten:: Knot a-> Int
verzweigungKnoten x y [] =0
verzweigungKnoten x y (a:b:[])=2
verzweigungKnoten x y (a:b:c) = 1+ verzweigungKnoten x y (b:c) 
verzweigungKnoten x y (v:vs:c) = verzweigungKnoten x y (v:vs:c)

--max :: Int -> Int -> Int
--max x y = if x>y then x else y