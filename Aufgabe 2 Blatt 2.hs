data MultTree a = Leaf a | Knot a a ([MultTree a])   deriving Show 

t1 :: MultTree Int
t1 = Knot 3 42[Knot 3 15[Leaf 3, Leaf 11, Leaf 12] , Knot 19 42[Leaf 42, Leaf 23]]

