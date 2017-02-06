gutePrim :: Int ->[Int]-> [Int]
gutePrim 0 [g] = []
gutePrim n (a:b:c:as) = if (b*b)>a*c then b:gutePrim (n-1) (b:c:as) else gutePrim n (b:c:as)

primes :: [Int]
primes = dropall(from 2)
dropall :: [Int]->[Int]
dropall (x:xs) = x: dropall (dropmult x xs)
take :: Int->[Int]->[Int]
take 0 _ = []
take n (x:xs) = x : Main.take (n-1) xs
filter :: (Int-> Bool)->[Int] ->[Int]
filter g [] =[]
filter g (x:xs) | g x = x : Main.filter g xs
                | otherwise = Main.filter g xs
from ::Int->[Int]
from x= x: from(x+1)
dropmult :: Int -> [Int]->[Int]
dropmult x xs = Main.filter(\y->mod y x /=0) xs


