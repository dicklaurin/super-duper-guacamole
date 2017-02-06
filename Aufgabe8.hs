goodPrimesInf :: [Int]
goodPrimesInf = goodPrimesInfStep (primes)

goodPrimesInfStep :: [Int] -> [Int]
goodPrimesInfStep (a:b:c:cs) = if b*b > a*c then a:goodPrimesInfStep (b:c:cs) else goodPrimesInfStep (b:c:cs)

--Vorlesung
from :: Int -> [Int]
from x = x : from (x+1)

dropall :: [Int] -> [Int]
dropall (x:xs) = x: dropall (dropMult x xs)

dropMult :: Int -> [Int] -> [Int]
dropMult x xs = filter (\y -> mod y x /= 0) xs

filter2 :: (a -> Bool) -> [a] -> [a]
filter2 g [] = []
filter2 g (x:xs) | g x		= x: filter g xs
                 | otherwise 	= filter g xs

primes :: [Int]
primes = dropall (from 2)