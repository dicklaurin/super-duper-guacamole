data List a = Nil | Cons a (List a) deriving Show

list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1  Nil))))

blist :: List Int
blist = Cons 1 (Cons 1 (Cons 0 (Cons 0 Nil)))

filterList :: (a -> Bool) -> List a -> List a
filterList _ Nil = Nil
filterList x (Cons y z)  | x y = Cons y (filterList x z)
                         | otherwise = filterList x z

divisibleBy :: Int -> List Int -> List Int
divisibleBy  x y = filterList(\z -> z `mod` x == 0) y

foldList :: (a-> b -> b ) -> b -> List a -> b
foldList x y Nil = y
foldList x y (Cons i k ) = x i (foldList x y  k)

plus x y =  x + y

listMaximum :: List Int -> Int
listMaximum (Cons x xs) = foldList (\z y-> max z y) x xs

zipLists :: (a -> b -> c) -> List a -> List b -> List c
zipLists _ Nil _ = Nil
zipLists _ _  Nil = Nil
zipLists f (Cons x xs) (Cons y ys) =  Cons (f x y) (zipLists f xs ys) 

skalarprodukt :: List Int -> List Int -> Int
skalarprodukt _ Nil = 0
skalarprodukt Nil _ = 0
skalarprodukt x y = foldList plus 0 (zipLists (*) x y )