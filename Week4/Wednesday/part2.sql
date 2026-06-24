EXPLAIN (ANALYZE, BUFFERS)
SELECT COUNT(*)
FROM product_event
WHERE product_id = 1;

-- "Aggregate  (cost=497.00..497.01 rows=1 width=8) (actual time=2.660..2.661 rows=1.00 loops=1)"
-- "  Buffers: shared hit=177"
-- "  ->  Seq Scan on product_event  (cost=0.00..477.00 rows=8000 width=0) (actual time=0.030..2.235 rows=8000.00 loops=1)"
-- "        Filter: (product_id = 1)"
-- "        Rows Removed by Filter: 16000"
-- "        Buffers: shared hit=177"
-- "Planning:"
-- "  Buffers: shared hit=29"
-- "Planning Time: 1.829 ms"
-- "Execution Time: 2.704 ms"

-- Seq Scan on product_even

CREATE INDEX idx_product_event_product_id
ON product_event(product_id);

EXPLAIN (ANALYZE, BUFFERS)
SELECT COUNT(*)
FROM product_event
WHERE product_id = 1;


-- "Aggregate  (cost=192.29..192.30 rows=1 width=8) (actual time=1.424..1.425 rows=1.00 loops=1)"
-- "  Buffers: shared hit=1 read=8"
-- "  ->  Index Only Scan using idx_product_event_product_id on product_event  (cost=0.29..172.29 rows=8000 width=0) (actual time=0.195..0.962 rows=8000.00 loops=1)"
-- "        Index Cond: (product_id = 1)"
-- "        Heap Fetches: 0"
-- "        Index Searches: 1"
-- "        Buffers: shared hit=1 read=8"
-- "Planning:"
-- "  Buffers: shared hit=18 read=1"
-- "Planning Time: 2.416 ms"
-- "Execution Time: 1.483 ms"

-- The execution time went down but the plan time went up slightly because now the query is able to use the idx_product_event_product_id INDEX
-- for faster lookup. 


EXPLAIN (ANALYZE, BUFFERS)
SELECT *
FROM product_event
WHERE product_id = 1
AND event_type = 'VIEW';

-- "Bitmap Heap Scan on product_event  (cost=57.60..295.05 rows=4030 width=25) (actual time=0.339..1.670 rows=4049.00 loops=1)"
-- "  Recheck Cond: ((product_id = 1) AND (event_type = 'VIEW'::text))"
-- "  Heap Blocks: exact=177"
-- "  Buffers: shared hit=177 read=5"
-- "  ->  Bitmap Index Scan on idx_product_event_product_type  (cost=0.00..56.59 rows=4030 width=0) (actual time=0.281..0.281 rows=4049.00 loops=1)"
-- "        Index Cond: ((product_id = 1) AND (event_type = 'VIEW'::text))"
-- "        Index Searches: 1"
-- "        Buffers: shared read=5"
-- "Planning:"
-- "  Buffers: shared hit=27 read=1 dirtied=1"
-- "Planning Time: 2.820 ms"
-- "Execution Time: 1.896 ms"