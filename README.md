# backend demo

## Development

```shell
docker-compose -f docker-compose.yml up
```

GET /animals

Response:

```json
[
  {
    "type": "carnivore",
    "name": "timberwolf"
  },
  {
    "type": "herbivore",
    "name": "rabbit"
  }
]
```

POST /animals

Request:

```json
{
  "type": "carnivore",
  "name": "beagle"
}
```

Response:

```json
{
  "id": "uuid",
  "type": "carnivore",
  "name": "beagle"
}
```

DELETE /animals/{uuid}
