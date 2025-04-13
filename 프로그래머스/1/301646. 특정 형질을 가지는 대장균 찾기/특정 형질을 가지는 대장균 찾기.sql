select count(*) as count
from ecoli_data
where conv(genotype, 10, 2) like '%01' or conv(genotype, 10, 2) like '%100' or conv(genotype, 10, 2) = 1